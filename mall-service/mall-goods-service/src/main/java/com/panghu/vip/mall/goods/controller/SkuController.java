package com.panghu.vip.mall.goods.controller;


import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Sku;
import com.panghu.vip.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@RestController
@RequestMapping("/mall-goods/sku")
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * 根据推广分类查询产品
     * @param id
     * @return
     */
    @GetMapping("/aditems/type")
    public List<Sku> typeItems(@RequestParam("id")Integer id) {
        List<Sku> skus = skuService.typeSkuItems(id);
        return skus;
    }

    @GetMapping("/deleteItems")
    public RespResult deleteItems(@RequestParam("id")Integer id) {
        skuService.deleteSkuItems(id);
        return RespResult.ok();
    }

    @GetMapping("/updateTypeSkuItems")
    public RespResult updateTypeSkuItems(@RequestParam("id")Integer id) {
        skuService.updateTypeSkuItems(id);
        return RespResult.ok();
    }

}

