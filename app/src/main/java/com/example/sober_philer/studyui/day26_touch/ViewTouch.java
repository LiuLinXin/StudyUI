package com.example.sober_philer.studyui.day26_touch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sober_philer on 2018/5/4.
 * description:
 */

public class ViewTouch extends View {
    public ViewTouch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("philerTest", "dispatchTouchEvent : "+event.getAction());
        boolean b = super.dispatchTouchEvent(event);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("philerTest", "onTouchEvent : "+event.getAction());
        boolean b = super.onTouchEvent(event);
        return b;
    }
}
