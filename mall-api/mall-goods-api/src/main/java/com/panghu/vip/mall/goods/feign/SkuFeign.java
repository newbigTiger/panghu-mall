package com.panghu.vip.mall.goods.feign;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/12 下午 3:32
 */
@FeignClient(value = "mall-goods")//服务名称
@RequestMapping("/mall-goods/sku")
public interface SkuFeign {

    @GetMapping(value = "/{id}")
    public RespResult<Sku> one(@PathVariable("id")String id);
    /**
     * 根据推广分类查询产品
     *
     * @param id
     * @return
     */
    @GetMapping("/aditems/type")
    public List<Sku> typeItems(@RequestParam("id") Integer id);

    @GetMapping("/deleteItems")
    public RespResult deleteItems(@RequestParam("id") Integer id);

    @GetMapping("/updateTypeSkuItems")
    public RespResult updateTypeSkuItems(@RequestParam("id") Integer id);
}
