package com.vapasi;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(String msg) {
        super(msg);
    }
}
