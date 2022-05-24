package com.panghu.vip.mall.goods.controller;

import com.panghu.vip.RespResult;
import com.panghu.vip.mall.order.model.Category;
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

    /**
     * 根据分类父id查询子类
     * @param id
     * @return
     */
    @GetMapping(value = "/parent/{id}")
    public RespResult<List<Category>> findByParentId(@PathVariable("id")Integer id){

        return RespResult.ok(categoryService.findByParentId(id));
    }
    /**
     * 根据分类查询分类信息
     */
    @GetMapping(value="/{id}")
    public RespResult<Category> one(@PathVariable(value = "id")Integer id){
        Category category = categoryService.getById(id);
        return RespResult.ok(category);
    }

}

