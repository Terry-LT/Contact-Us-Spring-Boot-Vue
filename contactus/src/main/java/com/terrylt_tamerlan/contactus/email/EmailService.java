package com.terrylt_tamerlan.contactus.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
    private final static Logger logger
            =  LoggerFactory.getLogger(EmailService.class);
    private JavaMailSender javaMailSender;
    @Async
    @Override
    public void send(String to, String subject ,String email) {
        //TODO: Check if to is empty, use the company email itself
    }
}
