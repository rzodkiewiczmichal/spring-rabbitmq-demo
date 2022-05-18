package com.rzodkiewicz.michal.rabbitmqdemo.controller;

import com.rzodkiewicz.michal.rabbitmqdemo.queue.QueueSender;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/message")
@Log4j2
@AllArgsConstructor
public class MessageController {

    private final QueueSender queueSender;

    @PostMapping()
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto value) {
        log.info("Received HTTP message request {}", value.getValue());
        queueSender.sendMessage(value.getValue());
        return ResponseEntity.ok(value);
    }
    

    @NoArgsConstructor
    @Getter
    private static final class MessageDto {
        private String value;
    }
}
