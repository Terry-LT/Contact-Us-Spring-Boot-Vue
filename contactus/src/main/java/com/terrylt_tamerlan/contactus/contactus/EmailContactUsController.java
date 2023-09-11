package com.terrylt_tamerlan.contactus.contactus;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()

@AllArgsConstructor
@RequestMapping(path = "api/v1/contactUs")
public class EmailContactUsController {
    private final EmailContactUsService emailContactUsService;

    @PostMapping
    public void sendContactUsPage(@RequestBody EmailContactUsRequest emailContactUsRequest){
        emailContactUsService.send(emailContactUsRequest);
    }
}
