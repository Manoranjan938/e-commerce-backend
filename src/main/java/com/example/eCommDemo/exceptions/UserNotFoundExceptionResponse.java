package com.example.eCommDemo.exceptions;

public class UserNotFoundExceptionResponse {

    private String message;

    public UserNotFoundExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
