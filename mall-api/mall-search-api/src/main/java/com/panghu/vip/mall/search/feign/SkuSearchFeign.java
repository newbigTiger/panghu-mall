package com.panghu.vip.mall.search.feign;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.search.model.SkuEs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 胖虎
 * @date 2022/5/16 下午 4:42
 */
@FeignClient(value = "mall-search")
@RequestMapping("/search")
public interface SkuSearchFeign {

    @GetMapping("/search")
    public RespResult<Map> search(@RequestParam Map<String, Object> searchMap);

    @PostMapping("/add")
    RespResult add(@RequestBody SkuEs skuEs);

    @PostMapping("/del/{id}")
    RespResult del(@PathVariable(value = "id") String id);
}
