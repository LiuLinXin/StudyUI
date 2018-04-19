package com.example.sober_philer.studyui.day19_behavior.behavior_scroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/19.
 * description:监听活动空间的Behavior
 */

public class ScrollBehavior extends CoordinatorLayout.Behavior<NestedScrollView> {

    int maxScroll;
    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull NestedScrollView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return directTargetChild.getId() == R.id.leftScroll || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull NestedScrollView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
        Log.i("philerTest", "accept");
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull NestedScrollView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        Log.i("philerTest", "onNestedScroll");
        if(maxScroll == 0){
            maxScroll = child.getScrollY();
        }
        child.setScrollY(maxScroll - target.getScrollY());
    }
}
