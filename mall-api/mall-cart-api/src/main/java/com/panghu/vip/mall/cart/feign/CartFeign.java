package com.panghu.vip.mall.cart.feign;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.cart.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 5:14
 */
@FeignClient(value = "mall-cart-service")
@RequestMapping("/mall-cart")
public interface CartFeign {

    @PostMapping("/delete")
    public RespResult delete(@RequestBody List<String> ids);

    @PostMapping("/list")
    public RespResult<List<Cart>> list(@RequestBody List<String> ids);
    /**
     * 增加购物车方法
     */
    @GetMapping(value = "/{id}/{num}")
    public RespResult add(@PathVariable(value = "id") String id, @PathVariable(value = "num")Integer num);

    @GetMapping(value = "/list")
    public RespResult<List<Cart>> list();

}
