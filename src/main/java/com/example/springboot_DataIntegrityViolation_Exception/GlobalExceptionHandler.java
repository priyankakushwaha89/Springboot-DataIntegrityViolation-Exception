 package com.example.springboot_DataIntegrityViolation_Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValildationException(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->
        {
        String fieldName=((FieldError)error).getField();
        String errorMessage=error.getDefaultMessage();
        errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleUniqueDataEntry(DataIntegrityViolationException exception, WebRequest request)
    {
        String errorMessage="Phone Number Already Registered";
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
    
}
