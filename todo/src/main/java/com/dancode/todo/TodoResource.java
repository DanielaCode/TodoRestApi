package com.dancode.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoResource {
    @Autowired
    private TodoRepository repository;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getTodosByUser(@PathVariable String username){
        return repository.findByUsername(username);
    }
    @GetMapping(path = "/users/{username}/todos/{id}")
    public Optional<Todo> getTodoById(@PathVariable String username, @PathVariable Integer id){
        return repository.findById(id);
    }
    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable Integer id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
