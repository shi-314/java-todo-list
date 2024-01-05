package com.github.shivan.javatodolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class TodoListController {
    ArrayList<TodoItem> todoList = new ArrayList<>();
    ArrayList<String> blackListedWords = new ArrayList<>(Arrays.asList("bad-word", "crap"));

    public boolean isBlackListed(String word) {
        return blackListedWords.contains(word);
    }

    @GetMapping("/todo-list")
    public String getTodoList() {
        String todoListString = "";

        for (TodoItem item : todoList) {
            if (!item.isDone) {
                todoListString += item.content + "<br>";
            } else {
                todoListString += "<s>" + item.content + "</s>" + "<br>";
            }
        }

        return todoListString;
    }

    @GetMapping("/add-item")
    public String addItem(@RequestParam("item") String itemContent) {
        if (isBlackListed(itemContent)) {
            return "Bad word detected";
        }

        TodoItem newItem = new TodoItem();
        newItem.content = itemContent;
        newItem.isDone = false;
        todoList.add(newItem);

        return "Add Item: " + itemContent;
    }

    @GetMapping("/mark-item")
    public String markItem(@RequestParam("index") int index) {
        todoList.get(index).isDone = !todoList.get(index).isDone;
        return "String";
    }
}
