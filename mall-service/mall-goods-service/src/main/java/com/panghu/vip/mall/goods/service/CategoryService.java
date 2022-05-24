package com.panghu.vip.mall.goods.service;

import com.panghu.vip.mall.goods.model.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
public interface CategoryService extends IService<Category> {
    List<Category> findByParentId(Integer pid);
}
