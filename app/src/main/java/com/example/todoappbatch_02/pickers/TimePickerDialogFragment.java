package com.example.todoappbatch_02.pickers;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.todoappbatch_02.utiles.TodoConstants;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        final Calendar calendar = Calendar.getInstance();
        calendar.set(0,0,0,i,i1);
        final String selectDate = sdf.format(calendar.getTime());
        final Bundle bundle = new Bundle();
        bundle.putString(TodoConstants.TIME_KEY, selectDate);
        bundle.putInt(TodoConstants.HOUR, i);
        bundle.putInt(TodoConstants.MINUTE, i1);
        getParentFragmentManager().setFragmentResult(TodoConstants.REQUEST_KEY, bundle);
    }
}
