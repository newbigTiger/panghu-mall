package com.panghu.vip.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author θθ
 * @date 2022/5/20 δΈε 2:48
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages =
        {"com.panghu.vip.mall.search.feign"})
public class MallWebSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebSearchApplication.class, args);
    }
}
