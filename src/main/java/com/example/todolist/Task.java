package com.example.todolist;

import java.time.LocalDate;

public class Task {

    private final long id;
    private final String content;
    private final LocalDate postDate;
    private final LocalDate dueDate;

    public Task(long id, String content, LocalDate dueDate) {
        this.id = id;
        this.content = content;
        this.postDate = LocalDate.now();
        this.dueDate = dueDate;
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
