package com.cloud.momo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "====== test a ====== ";
    }

    @GetMapping("/testB")
    public String testB() {
        return "====== test b ====== ";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "hotKeyTest" ,blockHandler = "handlerHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2){
        return "====== test hot key ======  ";
    }

    public String handlerHotKey(String p1, String p2, BlockException exception){
        return "====== test hot key too hot  boom!!! ======  ";
    }
}
