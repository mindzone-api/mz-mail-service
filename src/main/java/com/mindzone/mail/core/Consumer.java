package com.mindzone.mail.core;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Consumer {

    Service emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload DTO dto) {
        System.out.println("Email Status: " + emailService.sendEmail(dto));
    }
}
