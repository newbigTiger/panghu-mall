package com.panghu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panghu.vip.mall.goods.mapper.SkuAttributeMapper;
import com.panghu.vip.mall.order.model.SkuAttribute;
import com.panghu.vip.mall.goods.service.SkuAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-10
 */
@Service
public class SkuAttributeServiceImpl extends ServiceImpl<SkuAttributeMapper, SkuAttribute> implements SkuAttributeService {

    @Autowired
    private SkuAttributeMapper skuAttributeMapper;

    @Override
    public List<SkuAttribute> querySkuListByIds(Integer id) {
        return skuAttributeMapper.querySkuListByIds(id);
    }
}
