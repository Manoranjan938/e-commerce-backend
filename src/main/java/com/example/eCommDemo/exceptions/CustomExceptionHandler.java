package com.example.eCommDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleBadRequestException(DataAlreadyExistException ex, WebRequest request){

        DataAlreadyExistExceptionResponse exceptionResponse = new DataAlreadyExistExceptionResponse(ex.getMessage());

        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){

        UserNotFoundExceptionResponse exceptionResponse = new UserNotFoundExceptionResponse(ex.getMessage());

        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request){

        ProductNotFoundExceptionResponse exceptionResponse = new ProductNotFoundExceptionResponse(ex.getMessage());

        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

}
