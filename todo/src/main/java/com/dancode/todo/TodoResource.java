package com.dancode.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoResource {
    @Autowired
    private TodoRepository repository;

    @GetMapping(path = "/basicauth")
    public String basicAuth(){
        return "success";
    }
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

    @PutMapping(path = "/users/{username}/todos/{id}")
    public Todo updateTodoById(@PathVariable String username, @PathVariable Integer id, @RequestBody Todo todo){
        repository.save(todo);
        return todo;
    }

    @PostMapping(path = "/users/{username}/todos")
    public Todo createTodo(@PathVariable String username, @RequestBody Todo todo){
        todo.setUsername(username);
        todo.setId(null);
        return repository.save(todo);
    }
}
