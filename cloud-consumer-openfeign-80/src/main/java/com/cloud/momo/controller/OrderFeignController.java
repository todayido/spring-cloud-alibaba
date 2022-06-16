package com.cloud.momo.controller;

import com.cloud.momo.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/payment/feign")
    public String getPaymentFeign(){
        String result = paymentFeignService.paymentConsul();
        return result;
    }
}
