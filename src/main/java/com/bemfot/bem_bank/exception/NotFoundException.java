package com.bemfot.bem_bank.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private final HttpStatus statusCode;

    public NotFoundException(HttpStatus statusCode, String message ){
        super(message);
        this.statusCode = statusCode;
    }
}
