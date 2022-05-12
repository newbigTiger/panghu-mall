package com.panghu.vip.mall.goods.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.goods.model.Category;
import com.panghu.vip.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品类目 前端控制器
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@RestController
@RequestMapping("/mall-goods/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/findByParentId/{id}")
    public RespResult<List<Category>> findByParentId(@PathVariable("id")Integer id){

        return RespResult.ok(categoryService.findByParentId(id));
    }

}

