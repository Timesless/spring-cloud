package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author yangzl
 * @Date: 2020/8/23 12:35
 * @Desc:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsumerConsul80 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerConsul80.class, args);
    }
}
