package com.example.sober_philer.studyui.day31_paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/15.
 */

public class ViewCircleImage extends View {

    Bitmap bitmap;
    int height, width;
    int min, max;
    Paint paint;

    public ViewCircleImage(Context context) {
        super(context);
        init();
    }

    public ViewCircleImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.im3)).getBitmap();
        height = bitmap.getHeight();
        width = bitmap.getWidth();
        min = Math.min(height, width);
        max = Math.max(height, width);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Matrix matrix = new Matrix();
        float scale = (1f * getWidth() / min);
        matrix.setScale(scale, scale);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2, paint);
    }
}
