package com.yangzl.springcloud.service;

import com.yangzl.springcloud.entities.CommonResult;
import com.yangzl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author yangzl
 * @Date: 2020/8/23 15:47
 * @Desc: 自带ribbon负载均衡，添加Hystrix服务降级
 * 1. Ribbon + RestTemplate
 * 2. OpenFeign
 */

@Component
@FeignClient(value = "PAYMENT-PROVIDER", fallback = PaymentFeignFallbackService.class)
public interface PaymentFeignService {

    /**
     * 2020/8/23 声明与服务提供的controller相同
     * @param
     * @return
     */
    @GetMapping(path = "/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") long id);

    @GetMapping(path = "/payment/feign/timeout")
    String feignTimeout();

    // =========================================

    @GetMapping("/hystrix/ok")
    String hystrixOk();

    @GetMapping("/hystrix/timeout")
    String hystrixTimeout();
}
