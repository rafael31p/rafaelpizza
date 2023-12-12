package com.rafael.pizzeria.exceptions;

import java.io.Serializable;

public class CustomException extends RuntimeException implements Serializable {
    public CustomException(String message) {
        super(message);
    }
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

}
