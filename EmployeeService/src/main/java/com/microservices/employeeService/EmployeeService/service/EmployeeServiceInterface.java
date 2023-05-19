package com.microservices.employeeService.EmployeeService.service;

import com.microservices.employeeService.EmployeeService.dto.APIResponseDTO;
import com.microservices.employeeService.EmployeeService.dto.EmployeeDto;

public interface EmployeeServiceInterface {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDTO findById(Long employeeId);


}
