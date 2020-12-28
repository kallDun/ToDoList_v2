package com.example.todolist.controllers;

import com.example.todolist.models.Task;
import com.example.todolist.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
public class ToDoList_Controller {

    TaskService taskService = new TaskService();

    @PostMapping("/tasks")
    public void dbAdd(@RequestBody Task task){
        taskService.saveTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> dbGet(){
        return taskService.findAllTasks();
    }




    @PostMapping("/test") // Временный метод для быстрых тестов вставки Task
    public void dbTest(){
        Task task = new Task("Content", LocalDate.now().plusDays(2));
        taskService.saveTask(task);
        taskService.updateTask(task);
    }

}
