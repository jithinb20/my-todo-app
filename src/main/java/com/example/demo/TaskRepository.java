package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository gives us built-in methods like save(), deleteById(), and findAll()
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Spring is smart: it reads this method name and automatically creates a custom 
    // database query to sort our tasks mathematically by priority ascending!
    List<Task> findAllByOrderByPriorityAsc();
}