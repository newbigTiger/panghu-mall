package com.panghu.vip.mall.search.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.search.model.SkuEs;
import com.panghu.vip.mall.search.service.SkuSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 胖虎
 * @date 2022/5/16 下午 4:37
 */
@RestController
@RequestMapping(value = "/search")
public class SkuSearchController {

    @Autowired
    private SkuSearchService skuSearchService;


    /**
     * 商品搜索
     * @param searchMap
     * @return
     */
    @GetMapping("/search")
    public RespResult<Map> search(@RequestParam Map<String,Object> searchMap){
        Map<String, Object> search = skuSearchService.search(searchMap);
        return RespResult.ok(search);
    }

    @PostMapping("/add")
    public RespResult add(@RequestBody SkuEs skuEs) {

        skuSearchService.add(skuEs);
        return RespResult.ok();
    }

    @PostMapping("/create")
    public RespResult createIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        return RespResult.ok();
    }

    @PostMapping("/del/{id}")
    public RespResult del(@PathVariable(value = "id") String id) {
        skuSearchService.delete(id);
        return RespResult.ok();
    }


}
