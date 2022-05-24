package com.panghu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panghu.vip.mall.goods.mapper.BrandMapper;
import com.panghu.vip.mall.order.model.Brand;
import com.panghu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 7:31
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryList(Brand brand) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        queryWrapper.like("name",brand.getName());
        queryWrapper.eq("initial",brand.getInitial());

        return brandMapper.selectList(queryWrapper);
    }

    @Override
    public Page<Brand> queryPageList(Brand brand, Long current, Long size) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        queryWrapper.like("name",brand.getName());

        return (Page<Brand>) brandMapper.selectPage(new Page<Brand>(current,size),queryWrapper);
    }

    @Override
    public List<Brand> queryBrandIds(Integer id) {

        return brandMapper.queryBrandIds(id);
    }

}
