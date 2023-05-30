package com.example.demoProject.service;

import com.example.demoProject.dto.DemoDTO;
import com.example.demoProject.entity.DemoTable;
import com.example.demoProject.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoService {
    DemoRepository demoRepository;

    public DemoDTO getDemoDetails(Long id){
       Optional<DemoTable> demoTable= demoRepository.findById(id);

    }

}
