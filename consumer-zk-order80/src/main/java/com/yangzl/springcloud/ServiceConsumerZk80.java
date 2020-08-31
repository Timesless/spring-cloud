package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author yangzl
 * @Date: 2020/8/22 22:32
 * @Desc:
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsumerZk80 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerZk80.class, args);
    }
}
