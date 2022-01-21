package com.example.todoappbatch_02.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoappbatch_02.clickListener.DoubleClickListener;
import com.example.todoappbatch_02.databinding.TodoRowBinding;
import com.example.todoappbatch_02.entities.TodoModel;
import com.example.todoappbatch_02.lisener.OnTodoStatusChangedListener;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends ListAdapter<TodoModel, TodoAdapter.TodoViewHolder>   {
    private OnTodoStatusChangedListener listener;

    public TodoAdapter(Fragment fragment) {
        super(new TodoDiff());
        listener = (OnTodoStatusChangedListener) fragment;
    }
//    public void submitList(List<TodoModel> models){
//        this.models = models;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final TodoRowBinding binding = TodoRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new TodoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        final TodoModel todo = getItem(position);
        holder.bind(todo);
    }



//    @Override
//    public int getItemCount() {
//        if (models != null){
//            return models.size();
//        }
//        return 0;
//    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        private TodoRowBinding binding;

        public TodoViewHolder(TodoRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


//            binding.checkID.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    try{
//                        final  int position = getAdapterPosition();
//                        final TodoModel todoModel = getItem(position);
//                        todoModel.setCompleted(!todoModel.isCompleted());
//                        listener.onTodoStatusChanged(todoModel);
//
//                    }catch (Exception e){
//                        System.out.println(e);
//
//                    }
//
////                    binding.checkID.setEnabled(false);
//                }
//            });

            binding.checkID.setOnClickListener(new DoubleClickListener() {
                @Override
                public void onDoubleClick() {
                    final  int position = getAdapterPosition();
                        final TodoModel todoModel = getItem(position);
                        todoModel.setCompleted(!todoModel.isCompleted());
                        listener.onTodoStatusChanged(todoModel);
                }
            });
        }
        public  void bind(TodoModel todoModel){
            binding.setTodo(todoModel);
        }

    }

    public  static class TodoDiff extends DiffUtil.ItemCallback<TodoModel> {

        @Override
        public boolean areItemsTheSame(@NonNull TodoModel oldItem, @NonNull TodoModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
         public boolean areContentsTheSame(@NonNull TodoModel oldItem, @NonNull TodoModel newItem) {
            return oldItem.getId() == newItem.getId();
        }
    }
}
