package com.panghu.vip.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panghu.vip.mall.goods.model.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author θθ
 * @date 2022/5/7 δΈε 5:27
 */
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> queryBrandIds(@Param("id") Integer id);

}
