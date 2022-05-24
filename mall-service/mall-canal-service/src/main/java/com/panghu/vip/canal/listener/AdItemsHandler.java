package com.panghu.vip.canal.listener;

import com.panghu.vip.mall.goods.feign.SkuFeign;
import com.panghu.vip.mall.goods.model.AdItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

@CanalTable(value = "ad_items")
@Component
public class AdItemsHandler implements EntryHandler<AdItems> {

    @Autowired
    private SkuFeign skuFeign;

    @Override
    public void insert(AdItems adItems) {
        //加载缓存
        skuFeign.updateTypeSkuItems(adItems.getType());
    }

    /*** * 修改 * @param before * @param after */
    @Override
    public void update(AdItems before, AdItems after) {
        //分类不同，则重新加载之前的缓存
        if (null!=before.getType() && before.getType().intValue() != after.getType().intValue()) {
            //修改缓存
            skuFeign.updateTypeSkuItems(before.getType());
        }else {
            //加载缓存
            skuFeign.updateTypeSkuItems(after.getType());
        }
    }

    @Override
    public void delete(AdItems adItems) {
        //删除缓存
        skuFeign.deleteItems(adItems.getType());
    }
}