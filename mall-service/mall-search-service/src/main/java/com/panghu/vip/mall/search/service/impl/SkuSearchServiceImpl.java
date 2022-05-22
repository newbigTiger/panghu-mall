package com.panghu.vip.mall.search.service.impl;

import com.panghu.vip.PageInfo;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.panghu.vip.mall.search.mapper.SkuSearchMapper;
import com.panghu.vip.mall.search.model.SkuEs;
import com.panghu.vip.mall.search.service.SkuSearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 胖虎
 * @date 2022/5/16 下午 4:29
 */
@Service
public class SkuSearchServiceImpl implements SkuSearchService {

    @Autowired
    private SkuSearchMapper skuSearchMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     * 关键词搜索
     *
     * @return
     */
    @Override
    public Map<String, Object> search(Map<String, Object> searchMap) {
        //构建搜索条件
        NativeSearchQueryBuilder queryBuilder = queryBuilder(searchMap);
        //设置高亮
        HighlightBuilder.Field highlightBuilder = new HighlightBuilder
                .Field("name")
                .preTags("<span>")    //高亮前缀
                .postTags("</span>")  //高亮后缀
                .fragmentSize(100);   //碎片长度

        //分组搜索
        group(queryBuilder, searchMap);
        queryBuilder.withHighlightFields(highlightBuilder);
        //skuMapper进行搜索
        //Page<SkuEs> search = skuSearchMapper.search(queryBuilder.build());
        //AggregatedPage<SkuEs> search = (AggregatedPage<SkuEs>) skuSearchMapper.search(queryBuilder.build());
        AggregatedPage<SkuEs> search = elasticsearchRestTemplate.queryForPage(queryBuilder.build(), SkuEs.class);
        //解析分组数据
        Aggregations aggregations = search.getAggregations();
        Map<String, Object> stringObjectMap = parseGroup(aggregations);

        //获取结果集：集合列表，总记录数
        Map<String, Object> resultMap = new HashMap<>();
        attrParser(stringObjectMap);
        resultMap.put("list", search.getContent());
        resultMap.put("totalElements", search.getTotalElements());
        resultMap.put("totalPages", search.getTotalPages());
        resultMap.putAll(stringObjectMap);
        //创建分页对象
        int currentpage = queryBuilder.build().getPageable().getPageNumber()+1;
        PageInfo pageInfo= new PageInfo(search.getTotalElements(),currentpage,5);
        resultMap.put("pageInfo",pageInfo);
        return resultMap;
    }

    public void attrParser(Map<String, Object> searchMap) {
        //首先获取attrMaps
        Object attributemaps = searchMap.get("attributemaps");
        if (Objects.nonNull(attributemaps)) {
            //定义一个map集合里面是setString
            List<String> groupList = (List<String>) attributemaps;
            Map<String, Set<String>> allMaps = new HashMap<String, Set<String>>();
            for (String attr : groupList) {
                Map<String, String> attrMap = JSON.parseObject(attr, Map.class);
                for (Map.Entry<String, String> entry : attrMap.entrySet()) {
                    Set<String> values = allMaps.get(entry.getKey());
                    if (values == null) {
                        values = new HashSet<String>();
                    }
                    values.add(entry.getValue());
                    allMaps.put(entry.getKey(), values);
                }
            }
            searchMap.put("attributemaps", allMaps);
        }
    }

    /**
     * 分组结果解析
     *
     * @param aggregations
     * @return
     */
    public Map<String, Object> parseGroup(Aggregations aggregations) {
        Map<String, Object> map = new HashMap<>();
        if (aggregations == null) {
            return map;
        }
        for (Aggregation aggregation : aggregations) {
            //转为操纵字符串类型
            ParsedStringTerms pst = (ParsedStringTerms) aggregation;
            //定义一个集合列表存储分类
            List<String> stringList = new ArrayList<>();
            for (Terms.Bucket bucket : pst.getBuckets()) {
                stringList.add(bucket.getKeyAsString());
            }
            map.put(pst.getName(), stringList);
        }
        return map;
    }

    public NativeSearchQueryBuilder queryBuilder(Map<String, Object> searchMap) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //组合查询对象
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //判断关键词是否为空，不为空则设置条件
        if (searchMap != null && searchMap.size() != 0) {
            //根据名称模糊查询
            Object keywords = searchMap.get("keywords");
            if (!StringUtils.isEmpty(keywords)) {
                boolQueryBuilder.must(QueryBuilders.termQuery("name", keywords.toString()));
            }
            //根据分类查询
            Object category = searchMap.get("category");
            if (!StringUtils.isEmpty(category)) {
                boolQueryBuilder.must(QueryBuilders.termQuery("categoryName", category.toString()));
            }
            //品牌查询
            Object brand = searchMap.get("brand");
            if (!StringUtils.isEmpty(brand)) {
                boolQueryBuilder.must(QueryBuilders.termQuery("brandName", brand.toString()));
            }
            //价格区间
            Object price = searchMap.get("price");
            if (!StringUtils.isEmpty(price)) {
                String[] prices = price.toString().replace("元", "").replace("以上", "").split("-");
                //price大于第一个参数

                //price小于第二个参数
                if (prices.length == 2) {
                    boolQueryBuilder.must(QueryBuilders.rangeQuery("price").from(Integer.valueOf(prices[0]),false)
                            .to(Integer.valueOf(prices[1]),true));
                }else{
                    boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gt(Integer.valueOf(prices[0])));
                }
            }
            searchMap.forEach((k, v) -> {
                if (k.startsWith("attr_")) {
                    String key = "attrMap." + k.replaceFirst("attr_", "") + ".keyword";
                    String value = v.toString();
                    boolQueryBuilder.must(QueryBuilders.termQuery(key, value));
                }

            });
             queryBuilder.withQuery(boolQueryBuilder);
            Object sfield = searchMap.get("sfield");
            Object sm = searchMap.get("sm");
            if (!StringUtils.isEmpty(sfield) && !StringUtils.isEmpty(sm)) {
                queryBuilder.withSort(SortBuilders
                        .fieldSort(sfield.toString())
                        .order(SortOrder.valueOf(sm.toString())));
            }
        }
        queryBuilder.withPageable(PageRequest.of(currentPage(searchMap), 5));
        return queryBuilder;
    }

    public int currentPage(Map<String, Object> searchMap) {
        try {
            Object page = searchMap.get("page");
            return Integer.valueOf(page.toString()) - 1;
        } catch (Exception ex) {
            return 0;
        }
    }

    public void group(NativeSearchQueryBuilder queryBuilder, Map<String, Object> searchMap) {
        //用户如果没有输入分类条件，需要将分类搜索出来作为条件提供给用户
        if (searchMap == null || StringUtils.isEmpty((searchMap.get("category")))) {
            queryBuilder.addAggregation(
                    AggregationBuilders
                            .terms("categoryList")//用哪个别名接收
                            .field("categoryName")//根据categoryNamne进行分组
                            .size(100)//分组结果显示几个
            );
        }
        //如果用户没有输入品牌,需要将品牌搜索出来作为条件提供给用户
        if (searchMap == null || StringUtils.isEmpty(searchMap.get("brand"))) {
            queryBuilder.addAggregation(
                    AggregationBuilders
                            .terms("brandList")//用哪个别名接收
                            .field("brandName")//根据categoryNamne进行分组
                            .size(100)//分组结果显示几个
            );
        }
        queryBuilder.addAggregation(
                AggregationBuilders
                        .terms("attributemaps")//用哪个别名接收
                        .field("skuAttribute")//根据categoryNamne进行分组
                        .size(10000)//分组结果显示几个
        );
    }

    /**
     * 新增
     *
     * @param skuEs
     */
    @Override
    public void add(SkuEs skuEs) {
        //获取属性
        String skuAttribute = skuEs.getSkuAttribute();
        if (!StringUtils.isEmpty(skuAttribute)) {
            skuEs.setAttrMap(JSON.parseObject(skuAttribute, Map.class));
        }
        //填充map中
        skuSearchMapper.save(skuEs);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        skuSearchMapper.deleteById(id);
    }

}
