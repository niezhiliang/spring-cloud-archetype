package com.cloud.service.B.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rabbitmq")
public class RabbitController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "index")
    public String index (String str) {
        if (str == null) {
            str = "输入的内容为空";
        }
        amqpTemplate.convertAndSend("hello-queue", str);
        return "success";
    }
}
