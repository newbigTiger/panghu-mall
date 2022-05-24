package com.panghu.vip.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 胖虎
 * @date 2022/5/23 下午 7:12
 */
@SpringBootApplication
@MapperScan(basePackages = ("com.panghu.vip.mall.order.mapper"))
public class MallOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallOrderApplication.class, args);
    }
}
