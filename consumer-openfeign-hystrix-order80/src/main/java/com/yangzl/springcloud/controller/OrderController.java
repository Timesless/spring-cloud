package com.yangzl.springcloud.controller;

import com.yangzl.springcloud.entities.CommonResult;
import com.yangzl.springcloud.entities.Payment;
import com.yangzl.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author yangzl
 * @Date: 2020/8/23 15:53
 * @Desc:
 */

@Slf4j
@RestController
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("openfeign/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") String id) {
        return paymentFeignService.getPayment(Long.parseLong(id));
    }
    /**
     * 2020/8/30 测试feign超时
     * openfeign 默认等待1s，如果有长业务那么需配置ribbon ReadTimeout
     * @param
     * @return
     */
    @GetMapping("openfeign/timeout")
    public String feignTimeout() {
        return paymentFeignService.feignTimeout();
    }


    // ===============================================================
    // 测试Hystrix服务降级
    // 可以同服务端一样的配置，写handleMethod。但代码耦合度较高
    // ===============================================================
    @GetMapping("hystrix/ok")
    public String hystrixOk() {
        return paymentFeignService.hystrixOk();
    }

    @GetMapping("hystrix/timeout")
    public String hystrixTimeout() {
        return paymentFeignService.hystrixTimeout();
    }

}
