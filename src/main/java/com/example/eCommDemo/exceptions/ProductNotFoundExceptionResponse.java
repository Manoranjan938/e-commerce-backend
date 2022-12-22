package com.example.eCommDemo.exceptions;

public class ProductNotFoundExceptionResponse {

    private String message;

    public ProductNotFoundExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
