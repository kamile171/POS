package com.example.pos.Exceptions;

public class StaffNotFoundException extends RuntimeException{

    public StaffNotFoundException(Long staffId) {
        super("Could not find the staff member " + staffId);
    }
}
