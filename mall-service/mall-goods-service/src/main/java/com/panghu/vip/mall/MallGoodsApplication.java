package com.panghu.vip.mall;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author 胖虎
 * @date 2022/5/7 下午 5:25
 */
@SpringBootApplication
@MapperScan(basePackages = ("com.panghu.vip.mall.goods.mapper"))
public class MallGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGoodsApplication.class,args);
    }

}
