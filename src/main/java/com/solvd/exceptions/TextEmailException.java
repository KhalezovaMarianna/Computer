package com.solvd.exceptions;

public class TextEmailException extends Exception{

    public TextEmailException() {
    }

    public TextEmailException(String message) {
        super(message);
    }

    public TextEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextEmailException(Throwable cause) {
        super(cause);
    }

    public TextEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
