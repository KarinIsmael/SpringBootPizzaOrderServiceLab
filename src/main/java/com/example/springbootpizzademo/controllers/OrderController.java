package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.messagingrabbit.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final RabbitTemplate rabbitTemplate;

    public OrderController(RabbitTemplate rabbitTemplate){this.rabbitTemplate = rabbitTemplate;}

    @PostMapping("/orders")
    String orderPizza(@RequestBody Order newOrder){

        rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
                "pizza-routingkey", "two kebab special");

        return "Thank you, order is being processed";
    }
}
