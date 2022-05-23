package com.panghu.vip.mall.cart.service;

import com.panghu.vip.mall.cart.model.Cart;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 4:29
 */
public interface CartService {

    /**
     * 删除购物车数据
     * @param ids
     */
    void delete(List<String> ids);

    /**
     * 根据id集合查询数据
     * @param ids
     * @return
     */
    List<Cart> list(List<String> ids);
    /**
     * 加入购物车
     */
    Boolean add(String skuId,String userName,Integer number);

    List<Cart> list(String userName);
}
