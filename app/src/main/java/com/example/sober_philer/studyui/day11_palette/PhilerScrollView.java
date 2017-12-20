package com.example.sober_philer.studyui.day11_palette;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

/**
 * Created by philer on 2017/12/20.
 */

public class PhilerScrollView extends ScrollView {
    public ScrollListener getScrollListener() {
        return scrollListener;
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    public interface ScrollListener{
        void scroll(float percent);
    }

    private ScrollListener scrollListener;

    public PhilerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhilerScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PhilerScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public PhilerScrollView(Context context) {
        super(context);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        int maxHeight = (int) (screenHeight * 0.3);
        int scrollHeight = getScrollY();

        if(scrollHeight > maxHeight){
            scrollListener.scroll(1);
        }else {
            scrollListener.scroll((float)scrollHeight / maxHeight);
        }
    }
}
