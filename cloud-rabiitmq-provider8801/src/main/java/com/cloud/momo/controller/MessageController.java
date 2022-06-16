package com.cloud.momo.controller;

import com.cloud.momo.IMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {
    @Resource
    IMessage iMessage;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        iMessage.send();
        return "send success.";
    }
}
