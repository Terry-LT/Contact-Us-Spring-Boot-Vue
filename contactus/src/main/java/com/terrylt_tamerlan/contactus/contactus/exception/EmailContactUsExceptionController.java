package com.terrylt_tamerlan.contactus.contactus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class EmailContactUsExceptionController {
    @ExceptionHandler(value = EmailFromIsEmptyException.class)
    public ResponseEntity<Object> emailFromIsEmptyException(
            EmailFromIsEmptyException exception){
        HashMap<String, String> map = new HashMap<>();

        return new ResponseEntity<>(
                "The 'email' field cannot be empty!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(value = EmailSubjectIsEmptyException.class)
    public ResponseEntity<Object> emailSubjectIsEmptyException(
            EmailSubjectIsEmptyException exception){
        return new ResponseEntity<>(
                "The 'subject' field cannot be empty!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(value = EmailBodyIsEmptyException.class)
    public ResponseEntity<Object> emailBodyIsEmptyException(
            EmailBodyIsEmptyException exception){
        return new ResponseEntity<>(
                "The 'body' field cannot be empty!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(value = EmailPhoneNumberIsEmptyException.class)
    public ResponseEntity<Object> emailPhoneNumberIsEmptyException(
            EmailPhoneNumberIsEmptyException exception){
        return new ResponseEntity<>(
                "The 'phone number' field cannot be empty!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(value = EmailNotValidException.class)
    public ResponseEntity<Object> emailNotValidException(
            EmailNotValidException exception){
        return new ResponseEntity<>(
                "Email is not valid!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    @ExceptionHandler(value = EmailFailedException.class)
    public ResponseEntity<Object> emailFailedException(
            EmailFailedException exception){
        return new ResponseEntity<>(
                "Email failed to send!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
