package com.panghu.vip.mall.cart.mapper;

import com.panghu.vip.mall.cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 4:28
 */
public interface CartMapper extends MongoRepository<Cart,String> {
}
