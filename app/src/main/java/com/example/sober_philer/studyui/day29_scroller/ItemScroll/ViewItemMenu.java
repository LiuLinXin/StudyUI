package com.example.sober_philer.studyui.day29_scroller.ItemScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by 39716 on 2018/5/13.
 */

public class ViewItemMenu extends LinearLayout {

    Scroller scroller;
    float secoundViewWidth;

    public ViewItemMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        scroller = new Scroller(context);
    }

    float startX, startY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (secoundViewWidth == 0) {
            secoundViewWidth = getChildAt(1).getWidth();
        }
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            startX = ev.getX();
            startY = ev.getY();
        } else if (action == MotionEvent.ACTION_MOVE) {
            float nowX = ev.getX();
            float nowY = ev.getY();
            float dx = startX - nowX;
            float dy = startY - nowY;
            startX = nowX;
            startY = nowY;
            if (Math.abs(Math.abs(dx) - Math.abs(dy)) < ViewConfiguration.getTouchSlop()) {
                return true;
            }
            float lastX = getScrollX() + dx;
            if (lastX < 0) {
                lastX = 0;
            } else if (lastX > secoundViewWidth) {
                lastX = secoundViewWidth;
            }
            scrollTo((int) lastX, 0);
        } else if (action == MotionEvent.ACTION_UP) {
            int scrollX = getScrollX();
            if (scrollX > secoundViewWidth / 2) {
                float v = secoundViewWidth - getScrollX();
                scroller.startScroll(scrollX, 0, (int) v, 0);
            } else {
                scroller.startScroll(scrollX, 0, -scrollX, 0);
            }
            invalidate();
        }
        super.dispatchTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
