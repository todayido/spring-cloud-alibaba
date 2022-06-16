package momo.controller;

import lombok.extern.slf4j.Slf4j;
import momo.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("/payment/ok/{id}")
    public String getPaymentOK(@PathVariable("id") Integer id){
        String result = paymentFeignService.paymentOK(id);
        return result;
    }

    @GetMapping("/payment/timeout/{id}")
    public String getPaymentTimeout(@PathVariable("id") Integer id){
        String result = paymentFeignService.paymentTimOut(id);
        return result;
    }
}
