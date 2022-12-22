package com.example.eCommDemo.exceptions;

public class DataAlreadyExistExceptionResponse {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataAlreadyExistExceptionResponse(String data) {
        this.data = data;
    }

}
