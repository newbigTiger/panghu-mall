package com.panghu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.panghu.vip.mall.goods.model.Category;
import com.panghu.vip.mall.goods.mapper.CategoryMapper;
import com.panghu.vip.mall.goods.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findByParentId(Integer pid) {
        //条件封装对象
        QueryWrapper<Category> queryWrapper = new QueryWrapper<Category>();
        queryWrapper.eq("parent_id",pid);

        return categoryMapper.selectList(queryWrapper);
    }
}
