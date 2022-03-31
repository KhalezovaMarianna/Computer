package com.solvd.exceptions;

public class MouseModelException extends Exception {

    public MouseModelException() {
    }

    public MouseModelException(String message) {
        super(message);
    }

    public MouseModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public MouseModelException(Throwable cause) {
        super(cause);
    }

    public MouseModelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
