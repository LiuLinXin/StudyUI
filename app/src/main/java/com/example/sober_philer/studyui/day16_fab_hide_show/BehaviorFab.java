package com.example.sober_philer.studyui.day16_fab_hide_show;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by sober_philer on 2018/1/27.
 * description:
 */

public class BehaviorFab extends FloatingActionButton.Behavior {

    private boolean isShow = true;

    public BehaviorFab(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean onStartNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout,
            @NonNull FloatingActionButton child, @NonNull View directTargetChild,
            @NonNull View target, int axes, int type) {

        boolean b = axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        return b;
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScroll(
            @NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child,
            @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed,
            int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        if (dyConsumed > 10 && isShow) {
            hide(child);
            isShow = false;
        } else if (dyConsumed < -10 && !isShow) {
            show(child);
            isShow = true;
        }
    }

    private void hide(View view) {
        ViewCompat.animate(view).scaleX(0f).scaleY(0f).setDuration(500).setInterpolator(new AccelerateInterpolator()).start();
    }

    private void show(View view) {
        ViewCompat.animate(view).scaleX(1f).scaleY(1f).setDuration(500).setInterpolator(new DecelerateInterpolator()).start();
    }
}
