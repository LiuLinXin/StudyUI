package com.example.sober_philer.studyui.day28_use_touch;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 39716 on 2018/5/12.
 */

public class ListViewWrapContent extends ListView {
    public ListViewWrapContent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, i);
    }
}
