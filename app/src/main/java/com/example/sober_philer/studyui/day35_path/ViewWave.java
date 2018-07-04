package com.example.sober_philer.studyui.day35_path;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by philer on 2018/7/2.
 * Describe:
 */
public class ViewWave extends View {


    int transX = 0, transY = 400;
    Paint paint;


    int initHeight;
    int startHeight, startWidth;
    int waveWidth = 300;
    int waveHeight = 50;

    public ViewWave(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);
        post(new Runnable() {
            @Override
            public void run() {
                startAnim();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(initHeight == 0){
            initHeight = getHeight();
        }
        startHeight = initHeight - transY;
        startWidth = -waveWidth + transX;
        Path path = new Path();

        path.moveTo(startWidth, startHeight);
        for (int i = startWidth; i < getWidth() + waveWidth; i += waveWidth) {
            path.rQuadTo(waveWidth / 4, -waveHeight, waveWidth / 2, 0);
            path.rQuadTo(waveWidth / 4, waveHeight, waveWidth / 2, 0);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();
        canvas.drawPath(path, paint);
    }

    public void startAnim(){
        ValueAnimator valueAnimatorTransX = ValueAnimator.ofInt(0, waveWidth);
        valueAnimatorTransX.setInterpolator(new LinearInterpolator());
        valueAnimatorTransX.setRepeatCount(-1);
        valueAnimatorTransX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                transX = value;
                transY += 1;
                postInvalidate();
            }
        });
        valueAnimatorTransX.start();
    }
}
