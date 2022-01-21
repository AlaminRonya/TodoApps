package com.example.todoappbatch_02.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todoappbatch_02.daos.TodoDao;
import com.example.todoappbatch_02.entities.TodoModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TodoModel.class}, version = 1)
public abstract class TodoDB extends RoomDatabase {
    public abstract TodoDao getTodoDao();
    private static  TodoDB db;
    public static final ExecutorService service = Executors.newFixedThreadPool(4);
    public static TodoDB getInstance(Context context){
        if (db == null){
            db =  Room.databaseBuilder(context, TodoDB.class, "todo_db").build();
            return  db;
        }
        return db;
    }
}
