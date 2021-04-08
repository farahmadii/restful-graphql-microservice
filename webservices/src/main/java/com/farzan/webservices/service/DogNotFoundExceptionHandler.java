package com.farzan.webservices.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Dog with this id not found!")
public class DogNotFoundExceptionHandler extends RuntimeException{

    public DogNotFoundExceptionHandler() {
    }

    public DogNotFoundExceptionHandler(String message) {
        super(message);
    }
}
