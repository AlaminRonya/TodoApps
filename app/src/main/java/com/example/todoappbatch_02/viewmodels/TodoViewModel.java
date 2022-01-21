package com.example.todoappbatch_02.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todoappbatch_02.entities.TodoModel;
import com.example.todoappbatch_02.repo.TodoRepository;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository repository;
    public TodoViewModel(Application application) {
        super(application);
        repository = new TodoRepository(application);
    }
    public void insert(TodoModel todoModel){
        repository.insert(todoModel);
    }
    public void delete(TodoModel todoModel){
        repository.delete(todoModel);
    }
    public void update(TodoModel todoModel){
        repository.update(todoModel);
    }
    public LiveData<List<TodoModel>> getAllTodoModel(){
        return repository.getAllTodoModel();
    }
    public LiveData<List<TodoModel>> getAllTodosByStatus(boolean status){
        return repository.getAllTodosByStatus(status);
    }
    
}
