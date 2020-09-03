package com.yangzl.springcloud.service.impl;

import com.yangzl.springcloud.entities.Payment;
import com.yangzl.springcloud.mapper.PaymentMapper;
import com.yangzl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author yangzl
 * @Date: 2020/8/8 14:35
 * @Desc:
 */

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int savePayment(Payment payment) {
        return paymentMapper.savePayment(payment);
    }

    @Override
    public Payment queryPaymentById(Long id) {
        return paymentMapper.queryPaymentById(id);
    }
}
