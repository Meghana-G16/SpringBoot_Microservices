package com.redhat.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

    @GetMapping("/")
    public String firstCall(){
        return "Welcome to our spring boot application";
    }

    @GetMapping("/{name}")
    public String welcomeUser(@PathVariable String name){
        return "Welcome "+name+" to our red hat app";
    }
}
