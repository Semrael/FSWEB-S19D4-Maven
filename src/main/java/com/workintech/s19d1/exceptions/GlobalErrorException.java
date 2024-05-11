package com.workintech.s19d1.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalErrorException {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(ApiException apiException){
        ExceptionResponse exceptionResponse=new ExceptionResponse(apiException.getMessage(),apiException.getHttpStatus().value(), LocalDateTime.now());
        return new  ResponseEntity<>(exceptionResponse, apiException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(Exception exception){
        ExceptionResponse exceptionResponse=new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
