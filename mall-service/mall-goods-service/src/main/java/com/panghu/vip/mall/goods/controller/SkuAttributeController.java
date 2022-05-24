package com.panghu.vip.mall.goods.controller;


import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.SkuAttribute;
import com.panghu.vip.mall.goods.service.SkuAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@RestController
@RequestMapping("/mall-goods/sku-attribute")
@CrossOrigin
public class SkuAttributeController {

    @Autowired
    private SkuAttributeService skuAttributeService;

    @PostMapping(value = "/querySkuListByIds/{id}")
    public RespResult<List<SkuAttribute>> querySkuListByIds(@PathVariable(value = "id") Integer id){
        List<SkuAttribute> skuAttributes = skuAttributeService.querySkuListByIds(id);

        return RespResult.ok(skuAttributes);
    }

}

