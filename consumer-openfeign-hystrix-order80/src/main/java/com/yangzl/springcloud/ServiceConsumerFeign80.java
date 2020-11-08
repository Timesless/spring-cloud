package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author yangzl
 * @Date: 2020/8/23 15:45
 * @Desc:
 */

@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceConsumerFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerFeign80.class, args);
    }
}
