package com.cloud.momo.controller;

import com.cloud.momo.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result + serverPort);
        if (result > 0) {
            return new CommonResult(200, "插入成功！" + serverPort);
        }else{
            return new CommonResult(500, "服务器内部错误！" + serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getByPaymentId(id);
        log.info("查询结果：" + payment.toString() + serverPort);
        if (payment == null) {
            return new CommonResult(404, "数据查询不到！" + serverPort);
        } else {
            return new CommonResult(200, "查询成功！" + serverPort, payment);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getLB() {
        return serverPort;
    }
}
