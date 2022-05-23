package com.panghu.vip.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 6:03
 */
@SpringBootApplication
@MapperScan(basePackages = ("com.panghu.vip.mall.user.mapper"))
public class MallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class,args);
    }
}
