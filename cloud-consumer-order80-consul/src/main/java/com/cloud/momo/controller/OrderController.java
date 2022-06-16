package com.cloud.momo.controller;

import com.cloud.momo.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://consul-payment-service";
    @Resource
    private MyLB myLB;

    @Resource
    RestTemplate restTemplate;
    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/consul")
    public String consumerPaymentConsul() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return result;
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-payment-service");
        if (instances==null|| instances.size()==0) {
            return "无服务可用";
        }

        ServiceInstance instance = myLB.instances(instances);
        URI uri = instance.getUri();
        String result = restTemplate.getForObject(uri + "/payment/consul", String.class);
        return result;
    }
}
