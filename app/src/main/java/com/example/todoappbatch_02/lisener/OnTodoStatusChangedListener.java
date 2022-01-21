package com.example.todoappbatch_02.lisener;

import com.example.todoappbatch_02.entities.TodoModel;

public interface OnTodoStatusChangedListener {
    void onTodoStatusChanged(TodoModel todoModel);
}
