package com.example.TodoAPP.repository;

import com.example.TodoAPP.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepo {

    @Autowired
    private List<Todo> todoList;

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void add(Todo todo){

        todoList.add(todo);
    }

    public void delete(Todo todo){
        todoList.remove(todo);
    }

}
