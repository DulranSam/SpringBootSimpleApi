package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("home")
public class HelloWorld {

    @GetMapping("/username")
    public String username(){return "What's your username?";}
}
