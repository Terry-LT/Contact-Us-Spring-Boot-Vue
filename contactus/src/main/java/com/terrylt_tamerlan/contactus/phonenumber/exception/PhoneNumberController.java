package com.terrylt_tamerlan.contactus.phonenumber.exception;

import com.terrylt_tamerlan.contactus.phonenumber.PhoneNumberValidator;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhoneNumberController {
    @ExceptionHandler(value = PhoneNumberNotValidException.class)
    public ResponseEntity<Object> phoneNumberNotValidException(
            PhoneNumberNotValidException exception){

        return new ResponseEntity<>(
                "The phone number is not valid!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );

    }
}
