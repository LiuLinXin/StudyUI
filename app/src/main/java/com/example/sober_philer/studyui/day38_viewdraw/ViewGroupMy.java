package com.example.sober_philer.studyui.day38_viewdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by philer on 2018/7/4.
 * Describe:
 */
public class ViewGroupMy extends ViewGroup {
    public ViewGroupMy(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        int width = 0;
        int height = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            width += measuredWidth / 2;
            height += measuredHeight;
        }
        int widthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthSpec, heightSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int left = l;
        int top = t;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.layout(left, top, left+childAt.getMeasuredWidth(), top+childAt.getMeasuredHeight());
            left += childAt.getMeasuredWidth() / 2;
            top += childAt.getMeasuredHeight();
        }
    }
}
