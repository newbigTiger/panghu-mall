package com.panghu.vip.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.panghu.vip.mall.order.model.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 5:27
 */
@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> queryBrandIds(@Param("id") Integer id);

}
