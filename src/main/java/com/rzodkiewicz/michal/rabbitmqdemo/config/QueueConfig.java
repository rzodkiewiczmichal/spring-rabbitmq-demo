package com.rzodkiewicz.michal.rabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    public static final String HARDCODED_QUEUE = "hardcoded";


    /** This bean is found by RabbitAdmin and bound to the default exchange with 'hardcoded' routing key */
    @Bean
    public Queue hardcodedQueue() {
        return new Queue(HARDCODED_QUEUE, false);
    }
    
}
