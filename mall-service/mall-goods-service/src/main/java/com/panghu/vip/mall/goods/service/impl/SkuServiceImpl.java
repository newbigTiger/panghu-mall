package com.panghu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panghu.vip.mall.goods.mapper.AdItemsMapper;
import com.panghu.vip.mall.goods.mapper.SkuMapper;
import com.panghu.vip.mall.order.model.AdItems;
import com.panghu.vip.mall.order.model.Sku;
import com.panghu.vip.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Service
@CacheConfig(cacheNames = "ad-items-skus")
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private AdItemsMapper adItemsMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public int dcount(String id, Integer num) {
        int dcount = skuMapper.dcount(id, num);
        return dcount;
    }

    /**
     * 根据推广的分类ID查询该分类下的产品列表
     *
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    @Override
    public List<Sku> typeSkuItems(Integer id) {
        System.out.println("查询数据库");
        //1.获取当前分类下的所有产品列表
        QueryWrapper<AdItems> adItemsQueryWrapper = new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type", id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);
        //2.根据推广列表查询产品信息
        List<String> skuIds = adItems.stream().map(item -> item.getSkuId()).collect(Collectors.toList());
        List<Sku> skus = skuMapper.selectBatchIds(skuIds);
        return skus;
    }

    /**
     * 清除缓存通常是修改了这一类型的额redis缓存后需要做的
     *
     * @param id
     */
    @CacheEvict(key = "#id")
    @Override
    public void deleteSkuItems(Integer id) {

    }

    /**
     * 根据推广的分类ID修改redis缓存
     *
     * @param id
     * @return
     */
    @CachePut(key = "#id")
    @Override
    public List<Sku> updateTypeSkuItems(Integer id) {
        //1.获取当前分类下的所有产品列表
        QueryWrapper<AdItems> adItemsQueryWrapper = new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type", id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);
        //2.根据推广列表查询产品信息
        List<String> skuIds = adItems.stream().map(item -> item.getSkuId()).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(skuIds)){
            return Collections.emptyList();
        }
        List<Sku> skus = skuMapper.selectBatchIds(skuIds);
        return CollectionUtils.isEmpty(skus) ? Collections.emptyList() : skus;
    }
}
