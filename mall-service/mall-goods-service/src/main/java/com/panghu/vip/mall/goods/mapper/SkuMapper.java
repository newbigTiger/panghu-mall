package com.panghu.vip.mall.goods.mapper;

import com.panghu.vip.mall.goods.model.Sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Mapper
public interface SkuMapper extends BaseMapper<Sku> {

    @Update("update sku set num=num-#{num} where id=#{id} and num>#{num}")
    int dcount(@Param("id")String id,@Param("num")Integer num);

}
