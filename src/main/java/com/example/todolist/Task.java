package com.example.todolist;

import java.time.LocalDate;

public class Task {

    private long id;
    private final String content;
    private final LocalDate postDate;
    private final LocalDate dueDate;

    public Task(String content, LocalDate dueDate) {
        this.content = content;
        this.postDate = LocalDate.now();
        this.dueDate = dueDate;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}
