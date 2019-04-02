package com.example.sober_philer.studyui.day31_paint;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by 39716 on 2018/5/15.
 */

public class ViewScaning extends View {
    //外圈 默认70  最大80  可以缩小5
    //内圈 默认50  最大40

    Paint centerPaint;
    Paint sidePaint;
    private int statues;//当前的状态，0默，1默认到拍摄转换过程中，2拍摄中, 3拍摄到默认的转换过程中
    private float animPercent;//外圈动画进行的百分比
    private boolean down;

    public ViewScaning(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        centerPaint = new Paint();
        sidePaint = new Paint();
        centerPaint.setColor(Color.parseColor("#ff4c90ff"));
        sidePaint.setColor(Color.parseColor("#334c90ff"));
    }

    public void start(){
        statues = 1;
        animPercent = 0;
        postInvalidate();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
                drawNormal(canvas);

    }

    //绘制静态
    private void drawNormal(Canvas canvas){
        if(statues == 0) {
            float innerPercent = 50f / 80;
            float outerPercent = 70f / 80;
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * innerPercent, centerPaint);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * outerPercent, sidePaint);
        }else if(statues == 1){
            animPercent += 0.2f;
            if(animPercent >= 1f){
                animPercent = 1;
            }
            float innerPercent = (50f - animPercent * 10) / 80;
            float outerPercent = (70f + animPercent * 10) / 80;
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * innerPercent, centerPaint);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * outerPercent, sidePaint);

            if(animPercent == 1){
                statues = 2;
                animPercent = 0;
            }
            postInvalidate();
        }else if(statues == 2){
            if(!down) {
                animPercent += 0.1f;
                if (animPercent >= 1) {
                    animPercent = 1;
                    down = true;
                }
            }else {
                animPercent -= 0.1f;
                if (animPercent <= 0) {
                    animPercent = 0;
                    down = false;
                }
            }
            float innerPercent = 40f / 80;
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * innerPercent, centerPaint);

            BaseInterpolator interpolator = new AccelerateDecelerateInterpolator();
            float interpolation = interpolator.getInterpolation(animPercent);
            float outerPercent =(80f - 5 * interpolation) / 80;

            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * outerPercent, sidePaint);
            postInvalidate();
        }else if(statues == 3){
            animPercent += 0.1f;
            if(animPercent >= 1){
                animPercent = 1;
            }
            float innerPercent = (40f + animPercent * 10) / 80;
            float outerPercent = (80f - animPercent * 10) / 80;
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * innerPercent, centerPaint);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 * outerPercent, sidePaint);
            if(animPercent == 1){
                animPercent = 0;
                statues = 0;
            }
            postInvalidate();
        }
    }

}
