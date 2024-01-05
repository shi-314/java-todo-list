package com.github.shivan.javatodolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController {
    ArrayList<String> todoList = new ArrayList<>();

    @GetMapping("/todo-list")
    public String getTodoList() {

        String todoListString = "";

        for (String item : todoList) {
            todoListString += item + "<br>";
        }

        return todoListString;
    }

    @GetMapping("/add-item")
    public String addItem(
        @RequestParam("item") String item
    ) {
        todoList.add(item);

        return "Add Item: " +  item;
    }
}
