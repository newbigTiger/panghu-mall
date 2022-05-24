package com.panghu.vip.mall.cart.service.impl;

import com.google.common.collect.Lists;
import com.panghu.vip.RespResult;
import com.panghu.vip.mall.cart.mapper.CartMapper;
import com.panghu.vip.mall.cart.model.Cart;
import com.panghu.vip.mall.cart.service.CartService;
import com.panghu.vip.mall.goods.feign.SkuFeign;
import com.panghu.vip.mall.order.model.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 4:30
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void delete(List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {

            mongoTemplate.remove(Query.query(Criteria.where("_id").in(ids)),Cart.class);
        }
    }

    @Override
    public List<Cart> list(List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            Iterable<Cart> allById = cartMapper.findAllById(ids);
            return Lists.newArrayList(allById);
        }
        return null;
    }

    /**
     * @param skuId
     * @param userName
     * @param number:当前商品加入购物车总数
     * @return
     */
    @Override
    public Boolean add(String skuId, String userName, Integer number) {
        //ID不能冲突
        //1.删除当前商品之前的购物车记录
        cartMapper.deleteById(userName + skuId);
        if (number <= 0) {
            return false;
        }
        //2.根据ID查询商品详情将当前id商品对应数据加入mongoDB
        RespResult<Sku> skuRespResult = skuFeign.one(skuId);
        Sku sku = skuRespResult.getData();
        Cart cart = new Cart();
        cart.set_id(userName + skuId);
        cart.setUserName(userName);
        cart.setName(sku.getName());
        cart.setImage(sku.getImage());
        cart.setPrice(sku.getPrice());
        cart.setNum(number);
        Cart save = cartMapper.save(cart);
        return true;
    }

    /**
     * 根据用户名称查询购物车
     *
     * @param userName
     * @return
     */
    @Override
    public List<Cart> list(String userName) {
        Cart cart = new Cart();
        cart.setUserName(userName);

        return cartMapper.findAll(Example.of(cart), Sort.by("_id"));
    }
}
