package com.panghu.vip.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panghu.vip.mall.model.UserInfo;
import com.panghu.vip.mall.user.mapper.UserInfoMapper;
import com.panghu.vip.mall.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
