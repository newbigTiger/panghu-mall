package com.panghu.vip.mall.search.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.UrlUtils;
import com.panghu.vip.mall.search.feign.SkuSearchFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 胖虎
 * @date 2022/5/20 下午 2:46
 */
@Controller
@RequestMapping(value = "/web/search")
public class SearchController {

    @Autowired
    private SkuSearchFeign skuSearchFeign;
    /**
     * 搜索
     */
    @GetMapping
    public String search(@RequestParam(required = false) Map<String, Object> searchMap, Model model){
        RespResult<Map> mapRespResult = skuSearchFeign.search(searchMap);
        model.addAttribute("result", mapRespResult.getData());
        model.addAttribute("searchMap", searchMap);
        model.addAttribute("url", UrlUtils.map2url("/web/search",searchMap,"page"));
        model.addAttribute("sortUrl", UrlUtils.map2url("/web/search",searchMap,"page","sm","sfield"));
        return "search";
    }
}
