package com.yangzl.springcloud.controller;

import com.yangzl.springcloud.entities.CommonResult;
import com.yangzl.springcloud.entities.Payment;
import com.yangzl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

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

    @PostMapping("save")
    public CommonResult<Integer> savePayment(@RequestBody Payment payment) {
        Integer rs = paymentService.savePayment(payment);
        log.info("**** 插入结果：{}", rs);
        if (rs > 0) {
            return new CommonResult<>(200, port + ": success", rs);
        } else {
            return new CommonResult<>(404, port + ": error");
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id) {
        Payment rs = paymentService.queryPaymentById(id);
        log.info("***** 查询结果：{}", rs);
        if (Objects.nonNull(rs)) {
            return new CommonResult<>(200, port + ": success", rs);
        } else {
            return new CommonResult<>(200, port + ": success");
        }
    }
}
