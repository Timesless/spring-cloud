package com.yangzl.springcloud.mapper;

import com.yangzl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author yangzl
 * @Date: 2020/8/8 14:12
 * @Desc:
 */

@Mapper
public interface PaymentMapper {

    int savePayment(Payment payment);

    Payment queryPaymentById(@Param("id") Long id);
}
