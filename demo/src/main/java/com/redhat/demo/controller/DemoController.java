package com.redhat.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DemoController {
    @GetMapping("/")
    public String firstCall(){
        return "Welcome to the Java Spring Application";
    }
    @GetMapping("/{userName}")
    public String welcomeMeesage(@PathVariable String userName){
        return "Welcome "+userName+" to our red hat java application";
    }
}
