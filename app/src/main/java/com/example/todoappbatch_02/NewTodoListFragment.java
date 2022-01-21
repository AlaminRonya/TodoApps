package com.example.todoappbatch_02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.todoappbatch_02.databinding.FragmentNewTodoListBinding;
import com.example.todoappbatch_02.entities.TodoModel;
import com.example.todoappbatch_02.pickers.DatePickerDialogFragment;
import com.example.todoappbatch_02.pickers.TimePickerDialogFragment;
import com.example.todoappbatch_02.utiles.TodoConstants;
import com.example.todoappbatch_02.viewmodels.TodoViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class NewTodoListFragment extends Fragment {
    private FragmentNewTodoListBinding binding;
    private String dateString, timeString;
    private int year, month,day, hour, minute;
    private String priority  = TodoConstants.NORMAL;
    private TodoViewModel viewModel;

    public NewTodoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewTodoListBinding.inflate(inflater, container, false);
        initDateAndTime();
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                final RadioButton rb = radioGroup.findViewById(i);
                priority = rb.getText().toString();
            }
        });

        viewModel = new ViewModelProvider(requireActivity()).get(TodoViewModel.class);
//        final EmployeeAdapter adapter = new EmployeeAdapter(this);
        binding.dateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialogFragment().show(getChildFragmentManager(), null);
            }
        });
        binding.timeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialogFragment().show(getChildFragmentManager(), null);
            }
        });
        binding.saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = binding.editTextTextPersonName.getText().toString();
                final TodoModel todoModel = new TodoModel(name, priority, dateString, timeString, false);
                   viewModel.insert(todoModel);
                binding.editTextTextPersonName.setText("");
                scheduleNotificationWork(name);

            }
        });

        getChildFragmentManager().setFragmentResultListener(TodoConstants.REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if (result.containsKey(TodoConstants.DATE_KEY)){
                    dateString = result.getString(TodoConstants.DATE_KEY);
                    day = result.getInt(TodoConstants.DAY);
                    year = result.getInt(TodoConstants.YEAR);
                    month = result.getInt(TodoConstants.MONTH);
                    binding.dateBTN.setText(dateString);
                }else if (result.containsKey(TodoConstants.TIME_KEY)){
                    timeString = result.getString(TodoConstants.TIME_KEY);
                    hour = result.getInt(TodoConstants.HOUR);
                    minute = result.getInt(TodoConstants.MINUTE);
                    binding.timeBTN.setText(timeString);
                }
            }
        });

        return binding.getRoot();
    }

    private void initDateAndTime(){
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        timeString = new SimpleDateFormat("hh:mm a").format(new Date());


    }
    private  void scheduleNotificationWork(String name){
        final Calendar calendar = Calendar.getInstance();
    }
}