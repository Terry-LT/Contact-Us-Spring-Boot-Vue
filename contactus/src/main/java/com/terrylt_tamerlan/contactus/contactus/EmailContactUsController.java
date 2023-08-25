package com.terrylt_tamerlan.contactus.contactus;

import com.terrylt_tamerlan.contactus.email.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/contactUs")
public class EmailContactUsController {
    private final EmailService emailService;

    @PostMapping()
    public void sendContactUsPage(){
        emailService.send("","Contatc Us","idk@gm.com");
    }
}
