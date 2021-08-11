package com.ikramdg.exception;

public class StaffNotFoundException extends RuntimeException{

    public StaffNotFoundException(String message) {
        super(message);
    }

    public StaffNotFoundException(Long id) {
        super("Staff with id " + id + " not found");
    }

    public StaffNotFoundException() {
        super("Staff not found");
    }
}
