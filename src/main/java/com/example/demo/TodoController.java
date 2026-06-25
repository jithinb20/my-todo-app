package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired // Automatically injects the database engine here
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String viewTasks(Model model) {
        // Fetch perfectly sorted tasks straight from the database hard drive
        model.addAttribute("tasks", taskRepository.findAllByOrderByPriorityAsc());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String text, @RequestParam int priority) {
        if (!text.trim().isEmpty() && priority >= 1 && priority <= 9) {
            // Saves the object permanently to the database table
            taskRepository.save(new Task(text, priority));
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        // Deletes the specific row from the database using its unique identity number
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}