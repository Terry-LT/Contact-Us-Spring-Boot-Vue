package com.terrylt_tamerlan.contactus.phonenumber;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;


@Service
public class PhoneNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //Regex phone number
        //
        return s.matches("^\\d{11}$") || s.matches("^\\d{10}$");
    }
}
