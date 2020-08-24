package com.kgc.util;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEQU_EMAIL="email";
    public static final String QUEQU_SMS="sms";
    public static final String EXCHANGE="myexchangeTopic";

    @Bean(EXCHANGE)
    public Exchange createExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build();
    }
    @Bean(QUEQU_EMAIL)
    public Queue createEmailQueue(){
        Queue queue=new Queue(QUEQU_EMAIL);
        return queue;
    }
    @Bean(QUEQU_SMS)
    public Queue createSMSQueue(){
        Queue queue=new Queue(QUEQU_SMS);
        return queue;
    }

    @Bean
    public Binding bindingEmail(@Qualifier(EXCHANGE) Exchange exchange, @Qualifier(QUEQU_EMAIL) Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.email.#").noargs();
    }
    @Bean
    public Binding bindingSMS(@Qualifier(EXCHANGE) Exchange exchange, @Qualifier(QUEQU_SMS) Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("inform.#.sms.#").noargs();
    }

}
