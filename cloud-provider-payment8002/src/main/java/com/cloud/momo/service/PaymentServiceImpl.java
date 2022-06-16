package com.cloud.momo.service;

import com.cloud.momo.dao.PaymentDao;
import entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getByPaymentId(Long id) {
        return paymentDao.getByPaymentId(id);
    }
}
