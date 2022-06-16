package com.cloud.momo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosOrderController {

    @Resource
    RestTemplate restTemplate;

    @Value("${service.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    @ApiOperation("这块可以获取基本信息！")
    public String getInfo(@ApiParam("商品ID") @PathVariable("id") Integer id){
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }

    @GetMapping("/consumer/payment/nacos2")
    public String getInfo2(@ApiParam("用户ID") Integer id, @ApiParam("用户名") String name){
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }
}
