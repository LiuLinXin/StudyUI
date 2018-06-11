package com.example.sober_philer.studyui.day29_scroller;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * Created by 39716 on 2018/5/13.
 */

public class ScrollviewMy extends HorizontalScrollView {

    private int screenWidth, mMenuWidth;
    boolean once;
    View mMenu, mMain;

    public ScrollviewMy(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            once = true;
            ViewGroup viewGroup = (ViewGroup) getChildAt(0);
            mMenu = viewGroup.getChildAt(0);
            mMain = viewGroup.getChildAt(1);
            mMenuWidth = screenWidth - 200;
            mMenu.getLayoutParams().width = mMenuWidth;
            mMain.getLayoutParams().width = screenWidth;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            scrollTo(mMenuWidth, 0);
        }
        super.onLayout(changed, l, t, r, b);
    }

    float downX;
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            downX = ev.getX();
        } else if (action == MotionEvent.ACTION_UP) {
            float nowX = getX();
            float transX = Math.abs(nowX - downX);
            if (transX > mMenuWidth / 2) {
                smoothScrollTo(getWidth(), 0);
            } else {
                smoothScrollTo(0, 0);
            }
            return false;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        float factor = 1.0f * l / mMenuWidth;
//        ViewCompat.animate(mMenu).translationX(mMenuWidth * factor * 0.5f).start();
        mMenu.setTranslationX(mMenuWidth * factor * 0.5f);
    }
}
