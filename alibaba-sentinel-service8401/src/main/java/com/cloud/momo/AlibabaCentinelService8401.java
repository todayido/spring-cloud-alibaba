package com.cloud.momo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCentinelService8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaCentinelService8401.class, args);
    }
}
