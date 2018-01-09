package com.example.sober_philer.studyui.day15_cardview_floatingactionbar;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/1/9.
 * description:
 */

public class Day15Activity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab;
    private ViewGroup rvViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day15);
        fab = findViewById(R.id.fab);

        rvViews = findViewById(R.id.rvViews);
        fab.setOnClickListener(this);
    }

    private boolean show = false;

    @Override
    public void onClick(View v) {
        float rotation = show ? 0 : -(90 + 45);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(fab, "rotation", 0, rotation)
                .setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
        objectAnimator.setupStartValues();
        objectAnimator.start();
        show = !show;
        setViews(show);
    }

    private void setViews(boolean isShow) {
        int childCound = rvViews.getChildCount() - 1;
        for (int i = 0; i < childCound; i++) {
            View childAt = rvViews.getChildAt(i);
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(childAt, "translationY", 0, 0, isShow?-200 * (i+1):0)
                    .setDuration(100 * (i+1));
            objectAnimator.setupStartValues();
            objectAnimator.start();
        }
    }
}
