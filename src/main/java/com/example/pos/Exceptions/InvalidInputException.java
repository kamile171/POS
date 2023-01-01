package com.example.pos.Exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super("Invalid info input");
    }
}
