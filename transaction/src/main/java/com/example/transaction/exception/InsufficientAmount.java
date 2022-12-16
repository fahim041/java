package com.example.transaction.exception;

public class InsufficientAmount extends RuntimeException {
    public InsufficientAmount(String message){
        super(message);
    }
}
