package com.cloud.momo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "consul-payment-service")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/consul")
    String paymentConsul();
}
