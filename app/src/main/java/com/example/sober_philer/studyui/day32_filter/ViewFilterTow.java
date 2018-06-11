package com.example.sober_philer.studyui.day32_filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/16.
 */

public class ViewFilterTow extends View {
    public ViewFilterTow(Context context) {
        super(context);
        init();
    }

    public ViewFilterTow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.im4);
    }

    ColorMatrix colorMatrix = new ColorMatrix();
    Bitmap bitmap;
    Paint paint = new Paint();
    int light = 0xffffff;
    private int add = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColorFilter(new LightingColorFilter(0xffffff, add));
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            add = 100;
        }else if(action == MotionEvent.ACTION_UP){
            add = 0;
        }else {
            return true;
        }
        postInvalidate();
        return true;
    }
}
