package com.example.sober_philer.studyui.day16_fab_hide_show;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by sober_philer on 2018/1/12.
 * description:
 */

public class ViewGroupTestMeasureSpec extends LinearLayout {
    public ViewGroupTestMeasureSpec(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int atMost = MeasureSpec.AT_MOST;
        int exactly = MeasureSpec.EXACTLY;

        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);

        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
