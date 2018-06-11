package com.example.sober_philer.studyui.day20_propertyanimotion;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

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
    public void onClick(final View v) {
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

//                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
//                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f);
//                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f);
//                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(v, propertyValuesHolder1, propertyValuesHolder2, propertyValuesHolder3);
//                animator.setDuration(300);
//                animator.start();


//            ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, "scaleX", 0f, 1f);
//            ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, "scaleY", 0f, 1f);
//            ObjectAnimator scaleAlpha = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
//            AnimatorSet animatorSet = new AnimatorSet();
//            animatorSet.setDuration(500);
//            animatorSet.playTogether(scaleX, scaleY, scaleAlpha);
//            animatorSet.start();


            //估值器
//            ValueAnimator valueAnimator = new ValueAnimator();
//            valueAnimator.setDuration(4000);
//            valueAnimator.setObjectValues(new PointF());//如果不设置默认值会出错
//            //x = v t
//            //y = 1/2 * g * t²
//            valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
//                @Override
//                public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
//                    float x = 100 * fraction * 4;
//                    float y = (float) (0.5f * 98f * Math.pow(fraction * 4, 2));
//                    return new PointF(x, y);
//                }
//            });
//
//            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    PointF point = (PointF) animation.getAnimatedValue();
//                    v.setX(point.x);
//                    v.setY(point.y);
//                }
//            });
//            valueAnimator.start();


            //加速器
            ObjectAnimator translationX = ObjectAnimator.ofFloat(v, "translationX", 0, 600);
            translationX.setDuration(2000);
            translationX.setInterpolator(new AccelerateInterpolator());
            translationX.start();
        }
    }
}
