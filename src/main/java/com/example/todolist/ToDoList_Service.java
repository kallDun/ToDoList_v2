package com.example.todolist;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ToDoList_Service {

    private Long counter = 0L;
    private final Map<Long, Task> collection = new HashMap<>();
    private DatabaseTasks databaseTasks = new DatabaseTasks();

    @PostMapping("tasks")
    public void task(@RequestBody Task task)
    {
        task.setId(counter);
        collection.put(counter, task);
        counter++;
        databaseTasks.insertTask(collection.get(0));
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
