package com.example.todolist.services;

import com.example.todolist.jdbc.DatabaseTasks;
import com.example.todolist.models.Task;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ToDoList_Service {

    private Long counter = 0L;
    private final Map<Long, Task> collection = new HashMap<>();

    private DatabaseTasks databaseTasks = new DatabaseTasks();


    @PostMapping("/test") // Временный метод для тестов вставки
    public void dbTest(){
        /*Task task = new Task("new Content", LocalDate.now().plusDays(3));
        //task.setId(counter);
        counter++;

        try {
            databaseTasks.insertTask(task);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }*/
    }

    @GetMapping("/test") // Возвращает в json таблицу из базы данных
    public ArrayList<ArrayList<String[]>> taskReturn()
    {
        try {
            return databaseTasks.getTableTasks();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @PostMapping("tasks")
    public void task(@RequestBody Task task)
    {
        //task.setId(counter);
        collection.put(counter, task);
        counter++;

        try {
            databaseTasks.insertTask(collection.get(counter - 1));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
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
