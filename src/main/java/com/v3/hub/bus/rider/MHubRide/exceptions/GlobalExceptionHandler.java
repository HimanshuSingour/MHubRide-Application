package com.v3.hub.bus.rider.MHubRide.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusServiceException.class)
    ResponseEntity<ErrorMessage> routeNotFound(BusServiceException ex){
        ErrorMessage message = new ErrorMessage();
        message.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message , HttpStatus.NOT_FOUND);
    }
}
