package com.microservices.employeeService.EmployeeService.service.impl;

import com.microservices.employeeService.EmployeeService.dto.APIResponseDTO;
import com.microservices.employeeService.EmployeeService.dto.DepartmentDto;
import com.microservices.employeeService.EmployeeService.dto.EmployeeDto;
import com.microservices.employeeService.EmployeeService.entity.Employee;
import com.microservices.employeeService.EmployeeService.exception.EmailAlreadyExistsException;
import com.microservices.employeeService.EmployeeService.exception.ResourceNotFoundException;
import com.microservices.employeeService.EmployeeService.repository.EmployeeRepository;
import com.microservices.employeeService.EmployeeService.service.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    EmployeeRepository employeeRespository;
    ModelMapper modelMapper = new ModelMapper();
    //private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> employeeEmailCheck= employeeRespository.findByEmail(employeeDto.getEmail());
        if(employeeEmailCheck.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for a Employee");
        }

        Employee employeeObj = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRespository.save(employeeObj);
        EmployeeDto employeeDtoObj =modelMapper.map(savedEmployee, EmployeeDto.class);
        //EmployeeDto employeeDtoObj = Auto
        return employeeDtoObj;
    }

    @Override
    public APIResponseDTO findById(Long employeeId) {
        Employee employeeObj = employeeRespository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", employeeId)
        );

        //rest template
//        ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8082/api/departments/get/" + employeeObj.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto= responseEntity.getBody();

        //webclient -  bodytomono(responseType), synchronous calls need block()
        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8082/api/departments/get/" + employeeObj.getDepartmentCode())
                .retrieve().bodyToMono(DepartmentDto.class).block();

       // Optional<Employee> optionalObj = employeeRespository.findById(employeeId);
        //Employee employeeObj= optionalObj.get();
        EmployeeDto employeeDto= modelMapper.map(employeeObj, EmployeeDto.class);

        APIResponseDTO apiResponseDTO= new APIResponseDTO();
        apiResponseDTO.setEmployeeDto(employeeDto);
        apiResponseDTO.setDepartmentDto(departmentDto);
        //EmployeeDto employeeDto= new EmployeeDto(employeeObj.get().getId(), employeeObj.get().getFirstName(), employeeObj.get().getLastName(), employeeObj.get().getEmail());
        return apiResponseDTO;

    }
}
