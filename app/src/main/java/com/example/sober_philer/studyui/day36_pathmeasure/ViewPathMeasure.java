package com.example.sober_philer.studyui.day36_pathmeasure;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.sober_philer.studyui.R;

/**
 * Created by philer on 2018/7/3.
 * Describe:
 */
public class ViewPathMeasure extends View {

    Paint paint = new Paint();
    private int startHeight = 1000;
    private int waveWidth = 600;
    private int waveHeight = 50;
    Bitmap bitmap;

    Path path;
    Path pathTop;

    private float percent;//小船滑动的百分比

    public ViewPathMeasure(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        BitmapFactory.Options ops = new BitmapFactory.Options();
//        ops.inDensity = 2;
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_1, ops);
        startAnim();
    }

    private void initPath() {
        if (path != null || getWidth() == 0) {
            return;
        }
        path = new Path();
        pathTop = new Path();
        path.moveTo(-waveWidth, startHeight);
        pathTop.moveTo(-waveWidth, startHeight);
        for (int i = -waveWidth; i < getWidth() + waveWidth; i += waveWidth) {
            path.rQuadTo(waveWidth / 4, waveHeight, waveWidth / 2, 0);
            path.rQuadTo(waveWidth / 4, -waveHeight, waveWidth / 2, 0);

            pathTop.rQuadTo(waveWidth / 4, waveHeight, waveWidth / 2, 0);
            pathTop.rQuadTo(waveWidth / 4, -waveHeight, waveWidth / 2, 0);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPath();
        canvas.drawPath(path, paint);
        PathMeasure pathMeasure = new PathMeasure(pathTop, false);
        Matrix matri = new Matrix();
        pathMeasure.getMatrix(percent * pathMeasure.getLength(), matri, PathMeasure.POSITION_MATRIX_FLAG|PathMeasure.TANGENT_MATRIX_FLAG);
        matri.preTranslate(-bitmap.getWidth()/2, -bitmap.getHeight());
        canvas.drawBitmap(bitmap, matri, paint);
    }

    private void startAnim(){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                percent = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }
}
