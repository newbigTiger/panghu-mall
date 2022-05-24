package com.panghu.vip.mall.goods.service;

import com.panghu.vip.mall.order.model.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
public interface SkuService extends IService<Sku> {

    int dcount(String id,Integer num);
    /**
     * 根据推广的分类ID查询该分类下的产品列表
     * @param id
     * @return
     */
    List<Sku> typeSkuItems(Integer id);

    /**
     * 删除该分类，同时删除该分类的redis缓存
     * @param id
     */
    void deleteSkuItems(Integer id);

    /**
     * 根据推广的分类ID修改该分类下的产品列表
     * @param id
     * @return
     */
    List<Sku> updateTypeSkuItems(Integer id);
}
