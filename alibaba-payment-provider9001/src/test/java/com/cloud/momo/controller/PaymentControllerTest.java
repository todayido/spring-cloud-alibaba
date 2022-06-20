package com.cloud.momo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {PaymentControllerTest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPayment() {
        List list = new ArrayList<>();
        list.add("123");
        Assert.notEmpty(list);
    }

    @Test
    public void testPost() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/payment/nacos/1")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
//        log.info("响应状态: {}", mvcResult.getResponse().getStatus());
//        log.info("响应内容{}", mvcResult.getResponse().getContentAsString());
    }
}