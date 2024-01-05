package com.github.shivan.javatodolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {

    @GetMapping("/todo-list")
    public String getTodoList() {
        return "Todo List";
    }
}
