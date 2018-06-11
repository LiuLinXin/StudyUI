package com.example.sober_philer.studyui.day31_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 39716 on 2018/5/15.
 */

public class ViewAnimText extends android.support.v7.widget.AppCompatTextView {
    int transX = 0;

    public ViewAnimText(Context context) {
        super(context);
    }

    public ViewAnimText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        TextPaint paint = getPaint();
        String text = getText().toString();
        float textWidth = paint.measureText(text);
        float needWidth = 3f * textWidth / text.length();
        linearGradient = new LinearGradient(-needWidth, 0, 0, 0, new int[]{0xffff00ff,0xff00ff00,0xff00ff00,0xffff00ff}, new float[]{0,0.1f,0.9f,1}, Shader.TileMode.CLAMP);//边缘融合
        paint.setShader(linearGradient);
        matrix = new Matrix();
    }

    LinearGradient linearGradient;
    Matrix matrix;
    float deltaX = 20;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        transX += deltaX;
        matrix.setTranslate(transX, 0);
        linearGradient.setLocalMatrix(matrix);
        postInvalidateDelayed(50);
    }
}
