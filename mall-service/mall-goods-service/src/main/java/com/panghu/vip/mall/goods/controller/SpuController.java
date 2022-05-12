package com.panghu.vip.mall.goods.controller;


import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Product;
import com.panghu.vip.mall.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@RestController
@RequestMapping("/mall-goods/spu")
@CrossOrigin
public class SpuController {

    @Autowired
    private SpuService spuService;

    /**
     * 产品保存
     *
     * @param product
     * @return
     */
    @PostMapping(value = "/save")
    public RespResult add(@RequestBody Product product) {
        spuService.save(product);
        return RespResult.ok();
    }
}

