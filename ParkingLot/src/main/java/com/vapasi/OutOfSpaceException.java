package com.vapasi;

public class OutOfSpaceException extends RuntimeException {

    public OutOfSpaceException(String message) {
        super(message);
    }
}
