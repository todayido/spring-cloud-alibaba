package com.cloud.momo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GatwayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatwayMain.class, args);
    }
}
