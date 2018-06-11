package com.example.sober_philer.studyui.day31_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 39716 on 2018/5/15.
 */

public class ViewScaning extends View {

    int colors[] = new int[]{0xffffffff, 0xff00ffff, 0xffffffff};
    float position[] = new float[]{0, 0.01f,0.05f};
    SweepGradient sweepGradient;
    Paint paint = new Paint();
    Matrix matrix = new Matrix();
    float nowRotation = 0;

    public ViewScaning(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (sweepGradient == null) {
            sweepGradient = new SweepGradient(getWidth() / 2, getHeight() / 2, colors, position);

            paint.setShader(sweepGradient);
        }
        nowRotation -= 5;
        matrix.setRotate(nowRotation, getWidth()/2, getHeight()/2);
        sweepGradient.setLocalMatrix(matrix);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);
        postInvalidateDelayed(1);
    }
}
