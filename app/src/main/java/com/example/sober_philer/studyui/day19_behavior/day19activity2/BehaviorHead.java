package com.example.sober_philer.studyui.day19_behavior.day19activity2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 39716 on 2018/4/17.
 */

public class BehaviorHead extends CoordinatorLayout.Behavior<View> {

    public BehaviorHead(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof ImageView || super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        int y = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, y);

return true;
    }
}
