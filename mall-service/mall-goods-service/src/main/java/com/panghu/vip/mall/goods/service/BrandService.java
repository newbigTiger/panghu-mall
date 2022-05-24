package com.panghu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.panghu.vip.mall.goods.model.Brand;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 7:29
 */
public interface BrandService extends IService<Brand> {

    /**
     * 根据名称查询品牌
     * @param brand
     * @return
     */
    List<Brand> queryList(Brand brand);

    /**
     * 分页查询品牌
     * @param brand
     * @param current
     * @param size
     * @return
     */
    Page<Brand> queryPageList(Brand brand, Long current, Long size);

    /**
     * 根据分类查询品牌
     * @param id
     * @return
     */
    List<Brand> queryBrandIds(Integer id);
}
