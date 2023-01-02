package com.example.pos.Exceptions;

public class FaultNotFoundException extends RuntimeException{

    public FaultNotFoundException(Long faultId) {
        super("Could not find the fault with ID: " + faultId);
    }
}
