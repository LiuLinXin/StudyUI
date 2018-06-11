package com.example.sober_philer.studyui.day28_myview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 39716 on 2018/5/12.
 */

public class ViewMyTouch extends View {
    public ViewMyTouch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("philerTest", "View dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("philerTest", "View onTouchEvent");
        return super.onTouchEvent(event);
    }
}
