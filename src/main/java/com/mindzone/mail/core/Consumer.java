package com.mindzone.mail.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class Consumer {

    Service emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload DTO dto) {
        Status emailStatus = emailService.sendEmail(dto);
        if (emailStatus == Status.SENT) {
            log.info("EMAIL WAS SENT TO " + dto.getTo() + " ABOUT " + dto.getSubject());
        } else {
            log.error("EMAIL WAS NOT SENT TO " + dto.getTo() + " ABOUT " + dto.getSubject());
        }
    }
}
