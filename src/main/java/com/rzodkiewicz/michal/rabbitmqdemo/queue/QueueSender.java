package com.rzodkiewicz.michal.rabbitmqdemo.queue;

import static com.rzodkiewicz.michal.rabbitmqdemo.config.QueueConfig.HARDCODED_QUEUE;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class QueueSender {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String value) {
        this.rabbitTemplate.convertAndSend(HARDCODED_QUEUE, value);
    }
}
