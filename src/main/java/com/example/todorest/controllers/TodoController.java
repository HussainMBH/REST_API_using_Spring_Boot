package com.example.todorest.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.todorest.controllers.dtos.TodoDto;
import com.example.todorest.repositories.TodoRepo;


import java.util.List;

import entities.Todo;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping("/todos")
    public List<Todo> todos(){
        return this.todoRepo.findAll();
    }

     @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> geTodos(@PathVariable Long id){
        return this.todoRepo.findById(id)
            .map(todo ResponseEntity.ok().body(todo))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/todos")
    public ResponseEntity<Object> addTodo(@Valid @RequestBody TodoDto todoDto){
        this.todoRepo.save(new Todo(0, null, false));
        return ResponseEntity.ok().build();

    }
    
}
