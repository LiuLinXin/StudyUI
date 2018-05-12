package com.example.sober_philer.studyui.day28_use_touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by sober_philer on 2018/5/12.
 * description:
 */

public class ScrollViewCantouch extends ScrollView {
    public ScrollViewCantouch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
