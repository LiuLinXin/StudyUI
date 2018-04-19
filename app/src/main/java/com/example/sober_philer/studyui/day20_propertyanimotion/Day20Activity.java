package com.example.sober_philer.studyui.day20_propertyanimotion;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/19.
 * description:属性动画基础
 */

public class Day20Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day20);
        findViewById(R.id.buBu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.buBu) {
//            ObjectAnimator animator = ObjectAnimator.ofFloat(v, "translationY", 0, 200f);
//            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    animation.getAnimatedValue();//获取当前值
//                    animation.getAnimatedFraction();//获取百分比
//                }
//
//            });

            PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
            PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f);
            PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f);
            ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, propertyValuesHolder1, propertyValuesHolder2, propertyValuesHolder3);
            animator.setDuration(300);
            animator.start();
        }
    }
}
