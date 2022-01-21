package com.example.todoappbatch_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoappbatch_02.adapters.TodoAdapter;
import com.example.todoappbatch_02.databinding.FragmentAllTodoListBinding;
import com.example.todoappbatch_02.entities.TodoModel;
import com.example.todoappbatch_02.lisener.OnTodoStatusChangedListener;
import com.example.todoappbatch_02.viewmodels.TodoViewModel;

import java.util.List;


public class AllTodoListFragment extends Fragment implements OnTodoStatusChangedListener {
    private FragmentAllTodoListBinding binding;
    private TodoViewModel viewModel;

    public AllTodoListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllTodoListBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(TodoViewModel.class);
        binding.recyclerViewID.setLayoutManager(new LinearLayoutManager(getActivity()));
        final TodoAdapter adapter = new TodoAdapter(this);
        binding.recyclerViewID.setAdapter(adapter);
        viewModel.getAllTodosByStatus(false).observe(getViewLifecycleOwner(), new Observer<List<TodoModel>>() {
            @Override
            public void onChanged(List<TodoModel> models) {
                adapter.submitList(models);
//                if (models.isEmpty()){
//                    binding.recyclerViewID.setVisibility(View.VISIBLE);
//                }else {
//                    binding.recyclerViewID.setVisibility(View.GONE);
//                }
            }
        });



        return binding.getRoot();
    }

    @Override
    public void onTodoStatusChanged(TodoModel todoModel) {
        viewModel.update(todoModel);
    }
}