package com.panghu.vip.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author θθ
 * @date 2022/5/23 δΈε 7:12
 */
@SpringBootApplication
@MapperScan(basePackages = ("com.panghu.vip.mall.order.mapper"))
public class MallOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
    }
}
