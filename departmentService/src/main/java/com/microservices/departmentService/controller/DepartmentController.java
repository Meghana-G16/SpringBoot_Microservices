package com.microservices.departmentService.controller;

import com.microservices.departmentService.dto.DepartmentDto;
import com.microservices.departmentService.service.DepartmentServiceInterface;
import com.microservices.departmentService.service.impl.DepartmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentServiceInterface departmentService;
    // Build save department rest api
    @PostMapping(value="/saveDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        //DTO reads data from REST request
        DepartmentDto savedDepartment= departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    //Build get department rest api
    @GetMapping(value="get/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String departmentCode){
        DepartmentDto getDepartmentData = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(getDepartmentData, HttpStatus.OK);
    }
}
