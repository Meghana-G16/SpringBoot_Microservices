package com.microservices.employeeService.EmployeeService.repository;

import com.microservices.employeeService.EmployeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
