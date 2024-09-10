package com.bemfot.bem_bank.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<Object> errorResponse(HttpStatus statusCode, String message){
        return new ResponseEntity<>(new CustomResponse("error", message, null), statusCode);
    }

    public static ResponseEntity<Object> successResponse(String message, Object data, HttpStatus status) {
        return new ResponseEntity<>(new CustomResponse("success", message, data), status);
    }
}
