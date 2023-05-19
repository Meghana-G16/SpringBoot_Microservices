package com.microservices.departmentService.service.impl;

import com.microservices.departmentService.dto.DepartmentDto;
import com.microservices.departmentService.entity.Department;
import com.microservices.departmentService.exception.DepartmentCodeAlreadyExists;
import com.microservices.departmentService.repository.DepartmentRepository;
import com.microservices.departmentService.service.DepartmentServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentServiceInterface {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Optional<Department> departmentCodeCheck = Optional.ofNullable(departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode()));
       if(departmentCodeCheck.isPresent()){
           throw new DepartmentCodeAlreadyExists("Code exists is present for someother department in the DB");
       }

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department saveDepartment= departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentCode(),
        saveDepartment.getDepartmentName(),
        saveDepartment.getDepartmentDescription()
        );
        return savedDepartmentDto;

    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department getDepartmentDetails = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = new DepartmentDto(getDepartmentDetails.getId(), getDepartmentDetails.getDepartmentName(), getDepartmentDetails.getDepartmentDescription(), getDepartmentDetails.getDepartmentCode());
        return departmentDto;
    }

}
