package com.example.todoappbatch_02.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_todo")
public class TodoModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String priority;
    private String date;
    private String time;
    private boolean completed;

    public TodoModel(String name, String priority, String date, String time, boolean completed) {
        this.name = name;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.completed = completed;
    }

    @Ignore
    public TodoModel(int id, String name, String priority, String date, String time, boolean completed) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
