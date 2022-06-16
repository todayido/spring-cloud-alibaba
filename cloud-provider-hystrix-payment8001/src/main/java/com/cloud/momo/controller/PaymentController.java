package com.cloud.momo.controller;

import com.cloud.momo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentTimOutFallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
})
public class PaymentController {
    @Value("${server.port})")
    private String serverPort;

    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id) {
        int a = 10 / 0;
        String result = paymentService.paymentInfoOK(id);
        log.info("返回结果：" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentTimOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("返回结果：" + result);
        return result;
    }

    public String paymentTimOutFallback() {
        return "线程池：" + Thread.currentThread().getName() + " payment paymentTimOutFallback";
    }
}
