package com.sh.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证授权主启动
 *
 *
 * @author 盛浩
 * @date 2021/1/9 16:31
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SecurityOauth2Application {
    public static void main(String[] args) {
        SpringApplication.run(SecurityOauth2Application.class, args);
    }
}
