package com.panghu.vip.mall.user.controller;


import com.panghu.vip.RespResult;
import com.panghu.vip.mall.user.model.Address;
import com.panghu.vip.mall.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 胖虎
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/panghu-mall/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/list")
    public RespResult<List<Address>> list() {
        String userName = "panghu";
        List<Address> addressList = addressService.list(userName);
        return RespResult.ok(addressList);
    }

}

