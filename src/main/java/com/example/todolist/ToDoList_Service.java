package com.example.todolist;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ToDoList_Service {

    private Long counter = 0L;
    private final Map<Long, Task> collection = new HashMap<>();

    @PostMapping("/post")
    public void task(@RequestParam(value = "task_desc", defaultValue = "Something need to do...") String task_description)
    {
        collection.put(counter, new Task(counter++, task_description, LocalDate.now().plusDays(2)));
    }

    @GetMapping("/tasks")
    public Collection<Task> taskMap()
    {
        return collection.values();
    }


    @DeleteMapping("/remove/{id}")
    public void removeTask(@PathVariable long id){
        collection.remove(id);
    }

}
