package com.panghu.vip.canal.listener;

import com.alibaba.fastjson.JSON;
import com.panghu.vip.mall.order.model.Sku;
import com.panghu.vip.mall.page.feign.Pagefeign;
import com.panghu.vip.mall.search.feign.SkuSearchFeign;
import com.panghu.vip.mall.search.model.SkuEs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @author 胖虎
 * @date 2022/5/16 下午 5:44
 */
@CanalTable(value = "sku")
@Component
public class SkuHandler implements EntryHandler<Sku> {

    @Autowired
    private SkuSearchFeign skuSearchFeign;

    @Autowired
    private Pagefeign pagefeign;
    /**
     * 增加监听
     * @param sku
     */
    @Override
    public void insert(Sku sku){
        if(sku.getStatus().intValue() == 1){
            //将SKU转为JSON再将JSON转为es
            String skuJson = JSON.toJSONString(sku);
            skuSearchFeign.add(JSON.parseObject(skuJson, SkuEs.class));
        }
        try {
            pagefeign.html(sku.getSpuId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sku before, Sku after) {
        if(after.getStatus().intValue() == 2){
            skuSearchFeign.del(after.getId());
        }else{
            String skuJson = JSON.toJSONString(after);
            skuSearchFeign.add(JSON.parseObject(skuJson, SkuEs.class));
        }
        try {
            pagefeign.html(after.getSpuId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
