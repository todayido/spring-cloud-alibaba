package com.cloud.momo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfoOK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " payment is ok, id is " + id;
    }

    public String paymentInfoTimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " payment timeout, id is " + id;
    }
}
