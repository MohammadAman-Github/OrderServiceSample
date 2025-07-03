package com.demo.orderservicesample.Advice;

import com.demo.orderservicesample.Exception.OrderNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> getOrderNotFoundException(OrderNotFoundException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(400));
    }

}
