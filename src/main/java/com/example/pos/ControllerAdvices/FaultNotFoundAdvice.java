package com.example.pos.ControllerAdvices;

import com.example.pos.Exceptions.FaultNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class FaultNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FaultNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String faultNotFoundHandler(FaultNotFoundException ex) {
        return ex.getMessage();
    }
}
