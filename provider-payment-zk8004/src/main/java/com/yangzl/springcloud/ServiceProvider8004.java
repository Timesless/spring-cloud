package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author yangzl
 * @Date: 2020/8/22 21:54
 * @Desc:
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProvider8004 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8004.class, args);
    }
}
