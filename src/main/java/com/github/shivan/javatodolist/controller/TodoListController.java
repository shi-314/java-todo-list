package com.github.shivan.javatodolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController {
    ArrayList<TodoItem> todoList = new ArrayList<>();

    @GetMapping("/todo-list")
    public String getTodoList() {

        String todoListString = "";

        for (TodoItem item : todoList) {
            todoListString += item.content + "<br>";
        }

        return todoListString;
    }

    @GetMapping("/add-item")
    public String addItem(
        @RequestParam("item") String itemContent
    ) {
        TodoItem newItem = new TodoItem();
        newItem.content = itemContent;
        newItem.isDone = false;
        todoList.add(newItem);

        return "Add Item: " + itemContent;
    }

    @GetMapping("/mark-item")
    public String markItem (
            @RequestParam("index") int index
    ){
        todoList.get(index).isDone = !todoList.get(index).isDone;
        return "String";
    }
}
