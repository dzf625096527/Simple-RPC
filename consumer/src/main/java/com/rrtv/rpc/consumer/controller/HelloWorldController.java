package com.rrtv.rpc.consumer.controller;

import com.rrtv.rpc.api.service.HelloWordService;
import com.rrtv.rpc.client.annotation.RpcAutowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试RPC服务
 */
@Slf4j
@RestController
public class HelloWorldController {

    /**
     * RpcAutowired是通过定义了一个bean后置处理器将该变量通过动态代理的方式进行注入
     */
    @RpcAutowired(version = "1.0")
    private HelloWordService helloWordService;

    @GetMapping("/hello/world")
    public ResponseEntity<String> pullServiceInfo(@RequestParam("name") String name){
        log.info("name:{}", name);
        String s = helloWordService.sayHello(name);
        return  ResponseEntity.ok(s);
    }


}
