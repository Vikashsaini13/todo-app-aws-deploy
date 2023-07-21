package com.example.TodoAPP.service;

import com.example.TodoAPP.Entity.Todo;
import com.example.TodoAPP.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    public List<Todo> getAllTodos() {
        return todoRepo.getTodoList();
    }

    public List<Todo> getAllDoneTodos() {
        List<Todo> doneTodos=new ArrayList<>();

        for(Todo todo: todoRepo.getTodoList()){
            if(todo.isTodoDone()){
                doneTodos.add(todo);
            }
        }

        return doneTodos;
    }

    public List<Todo> getAllUnTodos() {
        List<Todo> unDoneTodos=new ArrayList<>();

        for(Todo todo: todoRepo.getTodoList()){
            if(!todo.isTodoDone()){
                unDoneTodos.add(todo);
            }
        }

        return unDoneTodos;
    }

    public String addTodo(Todo todo){
        todoRepo.add(todo);

        return "Todo added successfully";
    }

    public String updateTodoStatus(Integer todoId,boolean status){
        for(Todo todo: todoRepo.getTodoList()){
            if(todo.getTodoId().equals(todoId)){
                todo.setTodoDone(status);
                return "todo updated for todo id :" +todoId;
            }
        }

        return "todo not found for todoId :"+todoId;
    }


    public String removeTodo(Integer todoId){
        for(Todo todo: todoRepo.getTodoList()){
            if(todo.getTodoId().equals(todoId)){
                todoRepo.delete(todo);
                return "todo removed for todo id :" +todoId;
            }
        }

        return "todo not found for todoId :"+todoId;
    }
}
