package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Tells Spring to automatically create a database table for this class
public class Task {
    
    @Id // Marks this field as the unique identifier (Primary Key) for the row
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically counts up (1, 2, 3...)
    private Long id;
    
    private String text;
    private int priority;

    // A default constructor is strictly required by JPA
    public Task() {}

    public Task(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
}