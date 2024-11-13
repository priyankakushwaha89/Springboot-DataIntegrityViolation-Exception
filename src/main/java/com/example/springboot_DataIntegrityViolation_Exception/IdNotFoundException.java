package com.example.springboot_DataIntegrityViolation_Exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super(message);

    }
}
