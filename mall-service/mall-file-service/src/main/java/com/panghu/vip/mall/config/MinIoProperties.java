package com.panghu.vip.mall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 胖虎
 * @date 2022/5/9 下午 3:10
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinIoProperties {
    /**
     * minio地址+端口号
     */
    private String url;

    /**
     * minio用户名
     */
    private String accessKey;

    /**
     * minio密码
     */
    private String secretKey;

    /**
     * 文件桶的名称
     */
    private String bucketName;
}
