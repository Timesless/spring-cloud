package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author yangzl
 * @Date: 2020/8/30 20:55
 * @Desc:
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceProviderHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderHystrix8001.class, args);
    }
}
