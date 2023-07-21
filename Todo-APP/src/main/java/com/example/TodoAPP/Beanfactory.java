package com.example.TodoAPP;

import com.example.TodoAPP.Entity.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Beanfactory {

    @Bean
    public List<Todo> getDataSource(){
        return new ArrayList<>();
    }
}
