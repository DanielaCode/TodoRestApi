package com.dancode.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResorce {
    
    @GetMapping(path = "/todo")
    public Todo getTodo(){
        return new Todo();
    }
}
