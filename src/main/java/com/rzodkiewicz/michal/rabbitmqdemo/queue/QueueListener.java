package com.rzodkiewicz.michal.rabbitmqdemo.queue;

import static com.rzodkiewicz.michal.rabbitmqdemo.config.QueueConfig.HARDCODED_QUEUE;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class QueueListener {

    @RabbitListener(queues = HARDCODED_QUEUE)
    public void listen(String value) {
        log.info("Received message from hardcoded queue {}", value);
    }
    
}
