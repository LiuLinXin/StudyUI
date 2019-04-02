package com.example.sober_philer.studyui.day31_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 39716 on 2018/5/15.
 */

public class ViewRipple extends View {

    private float rippleSize;
    Paint paint = new Paint();
    RadialGradient radialGradient;
    float downX, downY;
    int[] color = new int[]{0xffffffff, 0xff990099, 0xffffffff};
    float[] positions = new float[]{0, 0.5f, 1};

    public ViewRipple(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(rippleSize >= 1) {
            if(rippleSize >= Math.min(getWidth(), getHeight())){
                rippleSize = 0;
                postInvalidate();
                return;
            }
            radialGradient = new RadialGradient(downX, downY, rippleSize, color, positions, Shader.TileMode.CLAMP);
//            Matrix matrix = new Matrix();
//            matrix.
            paint.setShader(radialGradient);
            canvas.drawCircle(downX, downY, rippleSize, paint);
            rippleSize += 20;
            postInvalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        downX = event.getX();
        downY = event.getY();
        rippleSize = 1;
        postInvalidate();
        return super.onTouchEvent(event);
    }


}
