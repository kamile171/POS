package com.example.pos.Exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(Long id) {
        super("Could not find the item " + id);
    }
}
