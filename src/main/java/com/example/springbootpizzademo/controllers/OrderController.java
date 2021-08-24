package com.example.springbootpizzademo.controllers;

import com.example.springbootpizzademo.messagingrabbit.RabbitMQConfiguration;
import org.hibernate.criterion.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
                "pizza-order", "Two kebab special with extra sallad and sauce");

        return "Thank you, order is being processed";
    }
}
