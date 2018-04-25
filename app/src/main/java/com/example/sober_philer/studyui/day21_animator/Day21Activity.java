package com.example.sober_philer.studyui.day21_animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/25.
 * description:属性动画综合demo
 */

public class Day21Activity extends AppCompatActivity implements View.OnClickListener {

    private View viewOne, viewTow;
    private boolean detailShow = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day21_activity);
        viewOne = findViewById(R.id.viewOne);
        viewTow = findViewById(R.id.viewTow);
        viewOne.setOnClickListener(this);
        viewTow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.viewOne){
            if(detailShow){
                return;
            }
            showDetail();
        }else {
            if(detailShow) {
                hideDetail();
            }
        }
    }

    private void showDetail(){
        detailShow = true;
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(viewOne, "rotationX", 0, 20);
        rotationX.setDuration(200);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(viewOne, "alpha", 1, 0.5f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(viewOne, "scaleX", 1, 0.8f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(viewOne, "scaleY", 1, 0.8f);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(viewOne, "translationY", 0, -viewOne.getHeight() * 0.1f);

        ObjectAnimator rotationXBack = ObjectAnimator.ofFloat(viewOne, "rotationX", 20, 0);
        rotationXBack.setDuration(200);
        rotationXBack.setStartDelay(200);

        ObjectAnimator translationYViewTow = ObjectAnimator.ofFloat(viewTow, "translationY", viewTow.getHeight(), 0);
        translationYViewTow.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                viewTow.setVisibility(View.VISIBLE);
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playTogether(alpha, rotationX, scaleX, scaleY, translationY, translationYViewTow,rotationXBack);
        animatorSet.start();
    }

    private void hideDetail(){
        detailShow = false;
    }
}
