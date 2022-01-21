package com.example.todoappbatch_02.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoappbatch_02.entities.TodoModel;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert
    void insert(TodoModel todoModel);

    @Delete
    void delete(TodoModel todoModel);

    @Update
    void update(TodoModel todoModel);

    @Query("SELECT * FROM tbl_todo WHERE completed= :status ORDER BY id ASC")
    LiveData<List<TodoModel>> getAllTodosByStatus(boolean status);



    @Query("SELECT * FROM tbl_todo  ORDER BY id DESC")
    LiveData<List<TodoModel>> getAllTodoModels();
}
