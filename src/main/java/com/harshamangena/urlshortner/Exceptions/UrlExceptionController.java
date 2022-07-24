package com.harshamangena.urlshortner.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlExceptionController {
    
    @ExceptionHandler(value = UrlAlreadyExistsException.class)
    public ResponseEntity<Object> exception(UrlAlreadyExistsException exception){
        return new ResponseEntity<>("Custom Url already exists in system", HttpStatus.EXPECTATION_FAILED);   
    }

}
