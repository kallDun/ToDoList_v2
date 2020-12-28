package com.example.todolist.services;

import com.example.todolist.dao.TaskDao;
import com.example.todolist.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskDao usersDao = new TaskDao();

    public TaskService() {
    }

    public Task findTask(int id) {
        return usersDao.findById(id);
    }

    public void saveTask(Task task) {
        usersDao.save(task);
    }

    public void deleteTask(Task task) {
        usersDao.delete(task);
    }

    public void updateTask(Task task) {
        usersDao.update(task);
    }

    public List<Task> findAllTasks() {
        return usersDao.findAll();
    }
}
