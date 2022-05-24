package com.panghu.vip.mall.goods.feign;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.order.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖虎
 * @date 2022/5/22 下午 5:25
 */
@FeignClient("mall-goods")
@RequestMapping("/mall-goods/category")
public interface CategoryFeign {

    /**
     * 根据分类查询分类信息
     */
    @GetMapping(value="/{id}")
    public RespResult<Category> one(@PathVariable(value = "id")Integer id);
}
