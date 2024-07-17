package com.example.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean completed;

    // Getter
    public Long getId() {
        return id;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    //getter
    public String getTitle() {
        return title;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    //getter
    public boolean isCompleted() {
        return completed;
    }

    //setter
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
