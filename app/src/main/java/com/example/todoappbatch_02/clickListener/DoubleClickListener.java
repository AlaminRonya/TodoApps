package com.example.todoappbatch_02.clickListener;


import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
public abstract class DoubleClickListener implements OnClickListener {
    // The time in which the second tap should be done in order to qualify as
    // a double click
    private static final long DEFAULT_QUALIFICATION_SPAN = 2000;
    private final long doubleClickQualificationSpanInMillis;
    private long timestampLastClick;

    public DoubleClickListener() {
        doubleClickQualificationSpanInMillis = DEFAULT_QUALIFICATION_SPAN;
        timestampLastClick = 0;
    }

    public DoubleClickListener(long doubleClickQualificationSpanInMillis) {
        this.doubleClickQualificationSpanInMillis = doubleClickQualificationSpanInMillis;
        timestampLastClick = 0;
    }

    @Override
    synchronized public void onClick(View v) {
        if((SystemClock.elapsedRealtime() - timestampLastClick) < doubleClickQualificationSpanInMillis) {

        }else {
            onDoubleClick();
            timestampLastClick = SystemClock.elapsedRealtime();
        }

    }

    public abstract void onDoubleClick();
}
