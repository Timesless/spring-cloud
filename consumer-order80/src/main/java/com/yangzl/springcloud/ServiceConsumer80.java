package com.yangzl.springcloud;

import com.yangzl.ribbon.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author yangzl
 * @Date: 2020/8/9 18:51
 * @Desc:
 */

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "PAYMENT-PROVIDER", configuration = RibbonRule.class)
public class ServiceConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumer80.class, args);
    }
}
