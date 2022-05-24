package com.panghu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.panghu.vip.mall.order.model.SkuAttribute;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
public interface SkuAttributeService extends IService<SkuAttribute> {
    /**
     * 获取全部的属性
     * @param id
     * @return
     */
    List<SkuAttribute> querySkuListByIds(Integer id);
}
