package com.terrylt_tamerlan.contactus.contactus;

import com.terrylt_tamerlan.contactus.contactus.exception.*;
import com.terrylt_tamerlan.contactus.email.EmailContactUsSender;
import com.terrylt_tamerlan.contactus.email.EmailValidator;
import com.terrylt_tamerlan.contactus.phonenumber.PhoneNumberValidator;
import com.terrylt_tamerlan.contactus.phonenumber.exception.PhoneNumberNotValidException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailContactUsService implements EmailContactUsSender {
    private final static Logger LOGGER
            =  LoggerFactory.getLogger(EmailContactUsService.class);
    private final JavaMailSender javaMailSender;
    private final EmailValidator emailValidator;
    private final PhoneNumberValidator phoneNumberValidator;
    @Async
    @Override
    public void send(EmailContactUsRequest emailContactUsRequest) {
        //Check if from is empty, throw custom error
        if (emailContactUsRequest.getFrom().isEmpty()){
            //Throw custom EmailFromIsEmptyException
            throw new EmailFromIsEmptyException();
        }
        //Check if subject is empty, throw custom error
        if (emailContactUsRequest.getSubject().isEmpty()){
            //Throw custom EmailSubjectIsEmptyException
            throw new EmailSubjectIsEmptyException();
        }
        //Check if body is empty, throw custom error
        if (emailContactUsRequest.getBody().isEmpty()){
            //Throw custom EmailBodyIsEmptyException
            throw new EmailBodyIsEmptyException();
        }
        //Check if phoneNumber is not empty
        if (emailContactUsRequest.getPhoneNumber().isEmpty()){
            //Throw custom EmailPhoneNumberIsEmptyException
            throw new EmailPhoneNumberIsEmptyException();
        }
        //Validations
        //Check if email is not valid
        if (!emailValidator.test(emailContactUsRequest.getFrom())){
           //Throw custom EmailNotValidException
            throw new EmailNotValidException();
        }
        //Check if phone number is not valid
        if (!phoneNumberValidator.test(emailContactUsRequest.getPhoneNumber())){
            //Throw custom PhoneNumberNotValidException
            throw new PhoneNumberNotValidException();
        }
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"utf-8");

            mimeMessageHelper.setText(
                    buildEmail(
                            emailContactUsRequest.getFrom(),
                            emailContactUsRequest.getPhoneNumber(),
                            emailContactUsRequest.getBody()
                            ),
                    true);

            mimeMessageHelper.setTo("company@companyexample.com");
            mimeMessageHelper.setSubject(emailContactUsRequest.getSubject());
            mimeMessageHelper.setFrom("company@companyexample.com");
            javaMailSender.send(mimeMessage);
        }
        catch (MessagingException e){
            LOGGER.error("Failed to email",e);
            //Throw Custom EmailFailedException
            throw new EmailFailedException();
        }
    }

    private String buildEmail(String from,String phoneNumber,String body){
        return  "<div>"
                +
                "From: "+from+"<br>"+"Phone number: "+phoneNumber+"<br>"
                +"Body:<br>" + body
                +
                "</div>";
    }
}
