package com.example.testvente.Exceptions;

public class Productexception extends RuntimeException {
    public Productexception(String message) {
        super(message);
    }

    public Productexception(String message, Throwable cause) {
        super(message, cause);
    }
}

