package com.kgc.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_EMAIL="email";
    public static final String QUEUE_MSG="msg";
    public static final String EXCHANGE="rabbitMQ";

    @Bean(EXCHANGE)
    public Exchange createExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build();
    }

    @Bean(QUEUE_EMAIL)
    public Queue createEmail(){
        Queue queue=new Queue(QUEUE_EMAIL);
        return queue;
    }

    @Bean(QUEUE_MSG)
    public Queue createMsg(){
        Queue queue=new Queue(QUEUE_MSG);
        return queue;
    }

    @Bean
    public Binding bindEmail(@Qualifier(EXCHANGE) Exchange exchange, @Qualifier(QUEUE_EMAIL) Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("info.#.email.#").noargs();
    }

    @Bean
    public Binding bindMsg(@Qualifier(EXCHANGE) Exchange exchange,@Qualifier(QUEUE_MSG) Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("info.#.msg.#").noargs();
    }
}
