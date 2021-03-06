package com.panghu.vip.mall.goods.feign;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author θθ
 * @date 2022/5/22 δΈε 5:31
 */
@FeignClient("mall-goods")
@RequestMapping("/mall-goods/spu")
public interface SpuFeign {

    @GetMapping("/product/{id}")
    public RespResult<Product> one(@PathVariable(value = "id")String id);
}
