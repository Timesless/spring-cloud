package com.yangzl.springcloud.service;


import com.yangzl.springcloud.entities.Payment;

/**
 * @Author yangzl
 * @Date: 2020/8/8 14:19
 * @Desc:
 */
public interface PaymentService {

    int savePayment(Payment payment);

    Payment queryPaymentById(Long id);
}
