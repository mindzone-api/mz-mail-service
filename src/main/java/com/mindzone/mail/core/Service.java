package com.mindzone.mail.core;


import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private JavaMailSender emailSender;

    public Status sendEmail(DTO dto) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(dto.getFrom());
            message.setTo(dto.getTo());
            message.setSubject(dto.getSubject());
            message.setText(dto.getText());
            emailSender.send(message);

            return Status.SENT;
        } catch (MailException e){
            return Status.ERROR;
        }
    }
}
