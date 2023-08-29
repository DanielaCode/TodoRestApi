package com.dancode.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoResource {
    @Autowired
    private TodoRepository repository;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getTodosByUser(@PathVariable String username){
        return repository.findByUsername(username);
    }
}
