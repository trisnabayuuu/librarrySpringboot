package com.example.login.exception;

public class EntityFoundException extends RuntimeException {
    public EntityFoundException(String message) {
        super(message);
    }
}