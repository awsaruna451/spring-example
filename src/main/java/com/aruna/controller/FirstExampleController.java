package com.aruna.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstExampleController {

    @GetMapping("/hello")
    public String sayHello() {
        return "HI";
    }
}
