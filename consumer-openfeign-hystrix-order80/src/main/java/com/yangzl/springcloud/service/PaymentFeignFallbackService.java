package com.yangzl.springcloud.service;

import com.yangzl.springcloud.entities.CommonResult;
import com.yangzl.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author yangzl
 * @Date: 2020/9/5 16:34
 * @Desc: hystrix 服务降级处理，解决与业务代码耦合
 */

@Component
public class PaymentFeignFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPayment(long id) {
        return new CommonResult<>(500, "服务出现异常，请稍后再试", null);
    }

    @Override
    public String feignTimeout() {
        return "服务调用超时";
    }

    // 通过 关闭服务提供者触发
    @Override
    public String hystrixOk() {
        return "服务调用发生异常";
    }

    @Override
    public String hystrixTimeout() {
        return "服务调用超时";
    }
}
