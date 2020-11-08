package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangzl
 * @date 2020/9/12 13:29
 * @desc
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayment9002 {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "9002");
        SpringApplication.run(NacosPayment9002.class, args);
    }
}
