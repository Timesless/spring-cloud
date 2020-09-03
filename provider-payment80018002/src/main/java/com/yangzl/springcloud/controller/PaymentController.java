package com.yangzl.springcloud.controller;

import com.yangzl.springcloud.entities.CommonResult;
import com.yangzl.springcloud.entities.Payment;
import com.yangzl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author yangzl
 * @Date: 2020/8/8 14:37
 * @Desc: 当前类只用于测试，正式环境不需要
 */

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;
    @Resource
    private PaymentService paymentService;
    /**
     * 暴露自己的服务信息
     */
    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @PostMapping("save")
    public CommonResult<Integer> savePayment(@RequestBody Payment payment) {
        Integer rs = paymentService.savePayment(payment);
        log.info("***** 插入结果：{}", rs);
        if (rs > 0) {
            return new CommonResult<>(200, port + ": success", rs);
        } else {
            return new CommonResult<>(404, port + ": error");
        }
    }

    @GetMapping(value = "get/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id) {
        Payment rs = paymentService.queryPaymentById(id);
        log.info("***** 查询结果：{}", rs);
        if (Objects.nonNull(rs)) {
            return new CommonResult<>(200, port + ": success", rs);
        } else {
            return new CommonResult<>(404, port + ": error");
        }
    }

    /**
     * 2020/8/15 获取服务信息
     * @param
     * @return
     */
    @GetMapping("discovery")
    public Object discovery() {
        List<ServiceInstance> serverInstances = discoveryClient.getInstances("PAYMENT-PROVIDER");
        serverInstances.forEach(instance ->
                log.info("***** serviceId is {},  server host is {}, server port is {}",
                        instance.getServiceId(), instance.getHost(), instance.getPort()));
        return discoveryClient;
    }

    /**
     * 2020/8/30 测试feign超时
     * @param
     * @return
     */
    @GetMapping("feign/timeout")
    public String feignTimeout() {
        try { TimeUnit.SECONDS.sleep(2); } catch(InterruptedException e) { e.printStackTrace(); }
        return port;
    }

}
