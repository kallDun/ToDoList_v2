package com.example.todolist.models;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDate postDate;

    private LocalDate dueDate;

    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Task(){

    }

    public Task(String content, LocalDate dueDate){
        this.content = content;
        this.dueDate = dueDate;
        this.postDate = LocalDate.now();
    }

}
