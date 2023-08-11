package com.yu.openapi.rpc.service;

import com.yu.openapi.rpc.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Task {

    @DubboReference
    private DemoService demoService;
    @Test
    void contextLoads() {
        System.out.println(demoService.sayHello("YJ"));
    }
}