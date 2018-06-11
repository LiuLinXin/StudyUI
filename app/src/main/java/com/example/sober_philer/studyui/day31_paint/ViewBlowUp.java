package com.example.sober_philer.studyui.day31_paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/15.
 */

public class ViewBlowUp extends View {
    Bitmap bitmap;
    int scaleMultiple = 4;
    int scaleSize = 200;
    BitmapShader scaledShader;
    private Matrix matrix = new Matrix();
    Paint paint = new Paint();

    public ViewBlowUp(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.im6);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * scaleMultiple, bitmap.getHeight() * scaleMultiple, true);
        scaledShader = new BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(scaledShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.drawCircle(lastX, lastY, scaleSize, paint);
    }

    float lastX, lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        lastX = event.getX();
        lastY = event.getY();
        matrix.setTranslate(scaleSize - lastX * scaleMultiple, scaleSize - lastY * scaleMultiple);
        scaledShader.setLocalMatrix(matrix);
        invalidate();
        return true;
    }
}
