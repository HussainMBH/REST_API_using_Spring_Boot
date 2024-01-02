package com.example.todorest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {
    
}
