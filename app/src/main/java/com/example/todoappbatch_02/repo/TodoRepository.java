package com.example.todoappbatch_02.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.todoappbatch_02.daos.TodoDao;
import com.example.todoappbatch_02.db.TodoDB;
import com.example.todoappbatch_02.entities.TodoModel;

import java.util.List;

public class TodoRepository {
    private TodoDao todoDao;
    public TodoRepository(Context context) {
        todoDao = TodoDB.getInstance(context).getTodoDao();
    }
    public void insert(TodoModel todoModel){
        TodoDB.service.execute(new Runnable() {
            @Override
            public void run() {
                todoDao.insert(todoModel);
            }
        });
    }
    public void delete(TodoModel todoModel){
        TodoDB.service.execute(new Runnable() {
            @Override
            public void run() {
                todoDao.delete(todoModel);
            }
        });
    }
    public void update(TodoModel todoModel){
        TodoDB.service.execute(new Runnable() {
            @Override
            public void run() {
                todoDao.update(todoModel);

            }

        });
    }
    public LiveData<List<TodoModel>> getAllTodoModel(){
        return todoDao.getAllTodoModels();

    }
    public LiveData<List<TodoModel>> getAllTodosByStatus(boolean status){
        return todoDao.getAllTodosByStatus(status);
    }
}
