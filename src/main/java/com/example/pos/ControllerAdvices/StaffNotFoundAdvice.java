package com.example.pos.ControllerAdvices;

import com.example.pos.Exceptions.StaffNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class StaffNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(StaffNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(StaffNotFoundException ex) {
        return ex.getMessage();
    }
}
