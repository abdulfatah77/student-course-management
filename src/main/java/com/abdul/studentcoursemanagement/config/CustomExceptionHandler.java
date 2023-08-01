package com.abdul.studentcoursemanagement.config;

/*
Author Name: abdul.fatah

Project Name: studentcoursemanagement

Package Name: com.abdul.studentcoursemanagement.config

Class Name: CustomExceptionHandler

Date and Time:8/1/2023 10:19 AM

Version:1.0
*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

