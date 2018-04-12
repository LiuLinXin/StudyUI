package com.example.sober_philer.studyui.day19_behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 39716 on 2018/4/12.
 */

public class FloatHideBehavior extends CoordinatorLayout.Behavior {

    public FloatHideBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        Log.i("philerTest", "dyConsumed : "+dyConsumed+" dyUnconsumed : "+dyUnconsumed);
        if(dyConsumed > 10){
            hide(child);
        }else if(dyConsumed < -10){
            show(child);
        }
    }

    private void show(View view){
        ViewCompat.animate(view).scaleX(1f).scaleY(1f).alpha(1f).setDuration(300).start();
    }
    private void hide(View view){
        ViewCompat.animate(view).scaleX(0f).scaleY(0f).alpha(0f).setDuration(300).start();
    }
}
