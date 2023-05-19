package com.microservices.employeeService.EmployeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
