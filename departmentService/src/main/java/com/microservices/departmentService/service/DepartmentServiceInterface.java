package com.microservices.departmentService.service;

import com.microservices.departmentService.dto.DepartmentDto;

public interface DepartmentServiceInterface {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
}
