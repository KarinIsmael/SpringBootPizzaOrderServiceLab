package com.example.springbootpizzademo.messagingrabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    public static final String topicExchangeName = "pizza-exchange";

    public static final String queueName = "pizza-queue";

    @Bean
    Queue queue(){

        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange(){

        return new TopicExchange(topicExchangeName);
    }

   @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("pizza-routingkey");
    }

    @Bean
    SimpleMessageListenerContainer container
            (ConnectionFactory connectionFactory,
             MessageListenerAdapter adapter){
        SimpleMessageListenerContainer container =
                new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(adapter);
        return container;
    }

    @Bean
    MessageListenerAdapter adapter (Reciever reciever){
        return new MessageListenerAdapter(reciever,"recieveMessage" );
    }

}
