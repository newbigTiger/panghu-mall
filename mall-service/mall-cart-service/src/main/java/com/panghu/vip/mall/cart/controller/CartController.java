package com.panghu.vip.mall.cart.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.cart.model.Cart;
import com.panghu.vip.mall.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 4:40
 */
@RestController
@RequestMapping("/mall-cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/delete")
    public RespResult delete(@RequestBody List<String> ids){
        cartService.delete(ids);
        return RespResult.ok();
    }

    @PostMapping("/list")
    public RespResult<List<Cart>> list(@RequestBody List<String> ids){
        List<Cart> list = cartService.list(ids);
        return RespResult.ok(list);
    }

    /**
     * 增加购物车方法
     */
    @GetMapping(value = "/{id}/{num}")
    public RespResult add(@PathVariable(value = "id") String id,@PathVariable(value = "num")Integer num){
        String userName = "panghu";
        cartService.add(id,userName,num);
        return RespResult.ok();
    }

    @GetMapping(value = "/list")
    public RespResult<List<Cart>> list(){
        String userName = "panghu";
        List<Cart> list = cartService.list(userName);
        return RespResult.ok(list);
    }
}
