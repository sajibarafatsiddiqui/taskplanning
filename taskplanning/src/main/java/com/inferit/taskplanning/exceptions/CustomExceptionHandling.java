package com.inferit.taskplanning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandling extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleexceptions(ExceptionHandling ex, WebRequest request){
        ExceptionHandlingResponse exceptionHandling=new ExceptionHandlingResponse(ex.getMessage());
        return new ResponseEntity(exceptionHandling, HttpStatus.BAD_REQUEST);

    }
}
