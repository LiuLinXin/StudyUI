package com.example.sober_philer.studyui.day28_use_touch;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 39716 on 2018/5/13.
 * 自定义ViewPager
 */

public class ViewPagerMyView extends ViewGroup {

    private boolean isScrolling;
    private float interceptDownX, interceptBeforX;
    private float touchBeforX;
    private int minScrollX;

    public ViewPagerMyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if(!changed){
            return;
        }
        int childCount = getChildCount();
        for (int i=0;i<childCount;i++){
            View childAt = getChildAt(i);
            childAt.layout(i * getMeasuredWidth(), t, (i + 1) * getMeasuredWidth(), childAt.getMeasuredHeight());
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        interceptBeforX = ev.getX();
        if(action == MotionEvent.ACTION_DOWN){
            interceptDownX = ev.getX();
        }else if(action == MotionEvent.ACTION_MOVE) {
            if(isScrolling){
                return true;
            }
            if(Math.abs(interceptBeforX - interceptDownX) > minScrollX){
                isScrolling = true;
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float nowX = event.getX();
        if(action == MotionEvent.ACTION_MOVE){
            float scrollX = touchBeforX - nowX;
            if(getScrollX() < -scrollX){
                scrollX = getScrollX();
            }else if(getScrollX() + scrollX > getWidth() * (getChildCount() - 1)){
                scrollX = getWidth() * (getChildCount() - 1) - getScrollX();
            }
            scrollBy((int) scrollX, 0);
        }else if(action == MotionEvent.ACTION_UP){
            int oneWidth = getWidth();
            int lastPage = Math.round(1f * getScrollX() / oneWidth);

            float lastScroll = lastPage * getWidth();
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f * getScrollX(), lastScroll);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float scroll = (float) animation.getAnimatedValue();
                    scrollTo((int) scroll, 0);
                }
            });
            valueAnimator.setDuration(300);
            valueAnimator.start();
        }
        touchBeforX = event.getX();
        return true;
    }
}
