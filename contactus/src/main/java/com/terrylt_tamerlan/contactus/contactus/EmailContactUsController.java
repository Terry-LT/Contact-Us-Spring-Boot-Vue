package com.terrylt_tamerlan.contactus.contactus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/contactUs")
public class EmailContactUsController {
    private final EmailContactUsService emailContactUsService;

    @PostMapping
    public void sendContactUsPage(@RequestBody EmailContactUsRequest emailContactUsRequest){
        emailContactUsService.send(emailContactUsRequest);
    }
}
