package com.example.todoappbatch_02.pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.todoappbatch_02.utiles.TodoConstants;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this,year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final Calendar calendar = Calendar.getInstance();
        calendar.set(i,i1,i2);
        final String selectDate = sdf.format(calendar.getTime());
        final Bundle bundle = new Bundle();
        bundle.putString(TodoConstants.DATE_KEY, selectDate);
        bundle.putInt(TodoConstants.YEAR, i);
        bundle.putInt(TodoConstants.MONTH, i1);
        bundle.putInt(TodoConstants.DAY, i2);
        getParentFragmentManager().setFragmentResult(TodoConstants.REQUEST_KEY, bundle);
    }
}
