package com.sh.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 组织主启动
 *
 *
 * @author 盛浩
 * @date 2021/1/16 13:24
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.sh.organization.user.mapper","com.sh.organization.menu.mapper"})
public class OrganizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }
}
