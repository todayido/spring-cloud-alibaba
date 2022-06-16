package com.cloud.momo;

import com.cloud.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(value = "consul-payment-service", configuration = MySelfRule.class)
public class OrderConsul {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsul.class, args);
    }
}
