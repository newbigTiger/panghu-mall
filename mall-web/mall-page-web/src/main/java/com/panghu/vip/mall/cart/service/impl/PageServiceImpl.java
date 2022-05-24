package com.panghu.vip.mall.cart.service.impl;

import com.alibaba.fastjson.JSON;
import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.feign.CategoryFeign;
import com.panghu.vip.mall.goods.feign.SpuFeign;
import com.panghu.vip.mall.goods.model.Category;
import com.panghu.vip.mall.goods.model.Product;
import com.panghu.vip.mall.goods.model.Sku;
import com.panghu.vip.mall.goods.model.Spu;
import com.panghu.vip.mall.cart.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 胖虎
 * @date 2022/5/22 下午 5:35
 */
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private CategoryFeign categoryFeign;

    @Autowired
    private SpuFeign spuFeign;

    @Value("${pagepath}")
    private String pagepath;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 生成静态页
     *
     * @param spuId
     * @throws Exception
     */
    @Override
    public void html(String spuId) throws Exception {
        //1.创建容器对象（上下文对象）
        Context context = new Context();
        //2.设置模板数据
        context.setVariables(loadDate(spuId));
        //3.指定文件生成后存储路径
        File file = new File(pagepath, spuId + ".html");
        PrintWriter printWriter = new PrintWriter(file, "UTF-8");
        //4.执行生成
        templateEngine.process("item", context, printWriter);
    }

    /**
     * 数据加载
     */
    public Map<String, Object> loadDate(String spuId) {
        RespResult<Product> pro = spuFeign.one(spuId);
        Product product = pro.getData();
        if (product != null) {
            //Map
            Map<String, Object> resultMap = new HashMap<>();
            //处理数据
            Spu spu = product.getSpu();
            resultMap.put("spu", spu);
            //图片处理
            resultMap.put("images", spu.getImages().split(","));
            //属性处理
            Map attrMaps = JSON.parseObject(spu.getAttributeList(), Map.class);
            resultMap.put("attrs", attrMaps);
            //三级分类查询
            RespResult<Category> one = categoryFeign.one(spu.getCategoryOneId());
            RespResult<Category> two = categoryFeign.one(spu.getCategoryTwoId());
            RespResult<Category> three = categoryFeign.one(spu.getCategoryThreeId());
            resultMap.put("one", one.getData());
            resultMap.put("two", two.getData());
            resultMap.put("three", three.getData());
            //Sku集合处理
            List<Map<String, Object>> skuList = new ArrayList<>();
            for (Sku sku : product.getSkus()) {
                Map<String, Object> skuMap = new HashMap<>();
                skuMap.put("id", sku.getId());
                skuMap.put("name", sku.getName());
                skuMap.put("price", sku.getPrice());
                skuMap.put("attr", sku.getSkuAttribute());
                skuList.add(skuMap);
            }
            resultMap.put("skuList", skuList);
            return resultMap;
        }
        return null;
    }
}
