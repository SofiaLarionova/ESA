package com.example.restful.util;

public class IdMismatchException extends RuntimeException {
    public IdMismatchException(String message) {
        super(message);
    }
}