package com.panghu.vip.mall.goods.mapper;

import com.panghu.vip.mall.order.model.SkuAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Mapper
public interface SkuAttributeMapper extends BaseMapper<SkuAttribute> {

    List<SkuAttribute> querySkuListByIds(@Param(value = "id") Integer id);
}
