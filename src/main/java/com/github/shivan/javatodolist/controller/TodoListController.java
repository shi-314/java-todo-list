package com.github.shivan.javatodolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {

    @GetMapping("/todo-list")
    public String getTodoList() {
        return "<b>Todo</b> List";
    }

    @GetMapping("/add-item")
    public String addItem(
        @RequestParam("item") String item
    ) {
        return "Add Item: " +  item;
    }
}
