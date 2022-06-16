package com.cloud.momo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderNacos9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderNacos9001.class, args);
    }
}
