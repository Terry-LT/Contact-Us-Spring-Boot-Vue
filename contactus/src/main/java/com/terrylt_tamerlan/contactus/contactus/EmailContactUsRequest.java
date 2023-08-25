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
    private final String from;
    //TODO: Add phone number regex
    private final String phoneNumber;
    private final String body;
}
