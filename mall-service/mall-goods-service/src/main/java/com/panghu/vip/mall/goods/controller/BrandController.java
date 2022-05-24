package com.panghu.vip.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Brand;
import com.panghu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 7:33
 */
@RestController
@RequestMapping(value = "/mall-goods/brand")
@CrossOrigin
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

    /**
     * 批量查询
     * @param brand
     * @return
     */
    @PostMapping("/search")
    public RespResult<List<Brand>> search(@RequestBody Brand brand){
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }
    /**
     * 批量查询
     * @param brand
     * @return
     */
    @PostMapping("/pageSearch/{page}/{size}")
    public RespResult<List<Brand>> pageSearch(
            @RequestBody Brand brand,
            @PathVariable(value = "page") Long page,
            @PathVariable(value = "size") Long size
            ){
        Page<Brand> brandPage = brandService.queryPageList(brand, page, size);
        return RespResult.ok(brandPage);
    }
    /**
     * 根据分类ID查询品牌集合
     * @param id
     * @return
     */
    @PostMapping("/queryBrandIds/{id}")
    public RespResult<List<Brand>> queryBrandIds(@PathVariable(value = "id") Integer id){
        List<Brand> brandPage = brandService.queryBrandIds(id);
        return RespResult.ok(brandPage);
    }
}
