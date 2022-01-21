package com.example.todoappbatch_02.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.todoappbatch_02.R;
import com.example.todoappbatch_02.utiles.TodoConstants;

public class TodoBindingAdapter {

    @BindingAdapter(value = "app:setPriorityIcon")
    public static void setPriorityIcon(ImageView imageView, String priority){
        int icon;
        switch (priority){
            case TodoConstants.LOW:
                icon = R.drawable.ic_priority_low_stars_24;
                break;
            case TodoConstants.NORMAL:
                icon = R.drawable.ic_priority_normal_stars_24;
                break;
            default:
                icon = R.drawable.ic_high_priority_star_24;
                break;
        }
        imageView.setImageResource(icon);
    }
}
