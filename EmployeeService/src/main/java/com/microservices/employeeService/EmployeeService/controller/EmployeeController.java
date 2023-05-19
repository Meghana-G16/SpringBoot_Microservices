package com.microservices.employeeService.EmployeeService.controller;

import com.microservices.employeeService.EmployeeService.dto.APIResponseDTO;
import com.microservices.employeeService.EmployeeService.dto.EmployeeDto;
import com.microservices.employeeService.EmployeeService.exception.ErrorDetails;
import com.microservices.employeeService.EmployeeService.exception.ResourceNotFoundException;
import com.microservices.employeeService.EmployeeService.service.EmployeeServiceInterface;
import com.microservices.employeeService.EmployeeService.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeServiceInterface employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDtoObj= employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDtoObj, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable Long id){
        APIResponseDTO apiResponseDTO= employeeService.findById(id);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }


    //to handle specific exception wrt to controller and exception class and return custom response back
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails= new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
