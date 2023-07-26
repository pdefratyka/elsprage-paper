package com.elsprage.paper.common.exception;

public class ResultException extends RuntimeException {

    public ResultException(String message) {

    }

    public static class ResultNotFoundException extends TagException {
        public ResultNotFoundException(long id) {
            super("Result with id: " + id + " not found");
        }
    }
}
