package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author yangzl
 * @Date: 2020/8/9 18:46
 * @Desc:
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7001 {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "7001");
        SpringApplication.run(EurekaServer7001.class, args);
    }
}
