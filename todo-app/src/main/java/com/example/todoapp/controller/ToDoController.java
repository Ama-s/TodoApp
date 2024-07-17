package com.example.todoapp.controller;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")

public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo not found"));
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDoDetails) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo not found"));
        toDo.setTitle(toDoDetails.getTitle());
        toDo.setCompleted(toDoDetails.isCompleted());
        return toDoRepository.save(toDo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo not found"));
        toDoRepository.delete(toDo);
    }
}
