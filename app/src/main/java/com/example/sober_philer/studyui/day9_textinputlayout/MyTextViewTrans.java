package com.example.sober_philer.studyui.day9_textinputlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sober_philer on 2017/12/11.
 * description:
 */

public class MyTextViewTrans extends TextView {
    public MyTextViewTrans(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Paint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        paint.setColor(Color.BLACK);
    }


    private int size;

    public void onStart(){

    }

    private int left, top, right, bottom;
    private float progress = 1;
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(this.right == 0){
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
