package com.example.demoProject.controller;


import com.example.demoProject.dto.DemoDTO;
import com.example.demoProject.entity.DemoTable;
import com.example.demoProject.service.DemoServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

    DemoServiceInterface demoServiceInterface;
    @GetMapping("/{id}")
    public ResponseEntity getDemoTableData(@PathVariable Long id){
        DemoDTO demoDto= demoServiceInterface.getDemoDetails(id);
        return new ResponseEntity<>(demoDto, HttpStatus.OK);
    }

}
