package com.panghu.vip.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author θθ
 * @date 2022/5/22 δΈε 5:18
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages = {
        "com.panghu.vip.mall.goods.feign"
})
public class MallPageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallPageApplication.class, args);
    }
}
