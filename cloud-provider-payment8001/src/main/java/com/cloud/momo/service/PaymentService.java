package com.cloud.momo.service;

import entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getByPaymentId(@Param("id") Long id);
}
