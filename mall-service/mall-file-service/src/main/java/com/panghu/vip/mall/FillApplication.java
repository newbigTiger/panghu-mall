package com.panghu.vip.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author θθ
 * @date 2022/5/9 δΈε 2:13
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class FillApplication {
    public static void main(String[] args) {
        SpringApplication.run(FillApplication.class, args);
    }
}
