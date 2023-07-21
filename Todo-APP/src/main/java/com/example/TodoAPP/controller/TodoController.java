package com.example.TodoAPP.controller;

import com.example.TodoAPP.Entity.Todo;
import com.example.TodoAPP.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;




    @GetMapping("todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("todo/done")
    public List<Todo> getDoneTodos(){
       return todoService.getAllDoneTodos();
    }

    @GetMapping("todo/undone")
    public List<Todo> getUnDoneTodos(){
        return todoService.getAllUnTodos();
    }

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo){
       return todoService.addTodo(todo);
    }


    @PutMapping("todo/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status){
        return todoService.updateTodoStatus(todoId,status);
    }


    @DeleteMapping("todo")
    public String removeTodo(@RequestParam Integer todoId){
       return todoService.removeTodo(todoId);
    }
}
