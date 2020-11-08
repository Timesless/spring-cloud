package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangzl
 * @date 2020/9/10 01:22
 * @desc
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayment9001 {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "9001");
        SpringApplication.run(NacosPayment9001.class, args);
    }

}
