package com.panghu.vip.mall.page.feign;

import com.panghu.vip.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖虎
 * @date 2022/5/22 下午 9:59
 */
@FeignClient(value = "mall-web-page")
@RequestMapping("/page")
public interface Pagefeign {

    @GetMapping("/{id}")
    RespResult html(@PathVariable(value = "id") String id)throws Exception;

}
