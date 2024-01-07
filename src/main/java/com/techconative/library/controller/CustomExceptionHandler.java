package com.techconative.library.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.techconative.library.exception.ResourceNotFoundExecption;
import com.techconative.library.response.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ResourceNotFoundExecption.class })
    public ResponseEntity<Object> handleRecordNotFoundException(
      Exception ex, WebRequest request) {
    	ErrorResponse errorResponse = new ErrorResponse();
    	errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    	errorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
    	errorResponse.setMessage(ex.getMessage());
    	errorResponse.setTimestamp(new Timestamp(new Date().getTime()));
        return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
}
