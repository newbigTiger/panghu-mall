package com.panghu.vip.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.panghu.vip.mall.user.model.Address;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
public interface AddressService extends IService<Address> {
    List<Address> list(String userName);
}
