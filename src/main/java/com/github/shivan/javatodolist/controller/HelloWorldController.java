package com.github.shivan.javatodolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/answer")
    public int answerToAllQuestions() {
        return 42;
    }
}
