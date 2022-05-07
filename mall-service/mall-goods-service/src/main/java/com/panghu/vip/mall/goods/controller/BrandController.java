package com.panghu.vip.mall.goods.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Brand;
import com.panghu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 7:33
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 新增方法
     * @param brand
     * @return
     */
    @PostMapping(value = "/add")
    public RespResult add(@RequestBody Brand brand){
        brandService.save(brand);
        return RespResult.ok();
    }

    /**
     * 修改
     * @param brand
     * @return
     */
    @PutMapping(value = "/update")
    public RespResult update(@RequestBody Brand brand){
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public RespResult delete(@PathVariable(value = "id") String id){
        brandService.removeById(id);
        return RespResult.ok();
    }
}