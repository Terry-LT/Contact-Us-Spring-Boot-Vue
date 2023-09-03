package com.terrylt_tamerlan.contactus.contactus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class EmailContactUsRequest {
    //Email
    //TODO: Add email regex
    private final String from;
    private final String subject;
    //TODO: Add phone number regex
    private final String phoneNumber;
    private final String body;
}
