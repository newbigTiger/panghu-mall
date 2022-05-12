package com.panghu.vip.mall.goods.service;

import com.panghu.vip.mall.goods.model.Product;
import com.panghu.vip.mall.goods.model.Spu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
public interface SpuService extends IService<Spu> {

    public void save(Product product);



}
