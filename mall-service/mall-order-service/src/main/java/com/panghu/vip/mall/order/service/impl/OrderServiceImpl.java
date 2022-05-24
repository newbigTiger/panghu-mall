package com.panghu.vip.mall.order.service.impl;

import com.panghu.vip.mall.goods.model.Order;
import com.panghu.vip.mall.order.mapper.OrderMapper;
import com.panghu.vip.mall.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
