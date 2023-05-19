package com.microservices.departmentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DepartmentCodeAlreadyExists.class)
    public ResponseEntity<ErrorDetails> DepartmentCodeAlreadyExistsException(DepartmentCodeAlreadyExists exception, WebRequest webRequest){
      ErrorDetails errorDetails= new ErrorDetails(
              LocalDateTime.now(),
              exception.getMessage(),
              webRequest.getDescription(false),
              "DEPARTMENT_CODE_EXISTS"
      );
      return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
