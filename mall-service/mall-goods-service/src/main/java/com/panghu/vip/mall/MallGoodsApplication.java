package com.panghu.vip.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author θθ
 * @date 2022/5/7 δΈε 5:25
 */
@SpringBootApplication
@MapperScan(basePackages = ("com.panghu.vip.mall.goods.mapper"))
@EnableCaching
public class MallGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGoodsApplication.class, args);
    }

}
