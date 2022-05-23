package com.panghu.vip.mall.cart.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.cart.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖虎
 * @date 2022/5/22 下午 6:07
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    PageService pageService;

    /**
     * 静态页生成
     */
    @GetMapping("/{id}")
    public RespResult html(@PathVariable(value = "id") String id)throws Exception{
        pageService.html(id);
        return RespResult.ok();
    }

}
