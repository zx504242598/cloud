package com.zx.cloud.security.controller;

import com.zx.cloud.common.result.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxuan
 * @date 2020-05-29 15:49
 **/
@RestController
@RequestMapping("/tasks")
public class TestController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    @GetMapping("/auth/test")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String test(){
        return "test";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/sendMessage")
    public R sendMessage(String message){
        kafkaTemplate.send("my-replicated-topic",message);
        return R.ok();
    }

}
