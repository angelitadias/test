package com.PbAbrilDes3.mspayment.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "paymentQueue";

    @Bean
    public Queue paymentQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}
