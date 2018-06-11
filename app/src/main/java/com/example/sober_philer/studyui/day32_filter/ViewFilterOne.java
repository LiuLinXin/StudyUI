package com.example.sober_philer.studyui.day32_filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/5/16.
 */

public class ViewFilterOne extends View {
    public ViewFilterOne(Context context) {
        super(context);
        init();
    }

    public ViewFilterOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private Bitmap bitmap;
    private Paint paint = new Paint();

    private void init(){
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.im1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        canvas.drawBitmap(bitmap, null, new RectF(0,0, 400, 400*bitmap.getHeight()/bitmap.getWidth()), paint);

        
        //模糊
        paint = new Paint();
        paint.setMaskFilter(new BlurMaskFilter(90, BlurMaskFilter.Blur.NORMAL));
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawBitmap(bitmap, null, new RectF(400,0, 800, 400*bitmap.getHeight()/bitmap.getWidth()), paint);

        //获得对应的滤镜颜色
        paint = new Paint();
        ColorMatrix redColorMatrix = new ColorMatrix(new float[]{
                1,0,0,0,0,
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,1,0,
        });
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(redColorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(bitmap, null, new RectF(0, 400*bitmap.getHeight()/bitmap.getWidth(), 400, 400*bitmap.getHeight()/bitmap.getWidth() * 2), paint);

        ColorMatrix greenColorMatrix = new ColorMatrix(new float[]{
                0,0,0,0,0,
                0,1,0,0,0,
                0,0,0,0,0,
                0,0,0,1,0,
        });
        ColorMatrixColorFilter greenMatrixColorFilter = new ColorMatrixColorFilter(greenColorMatrix);
        paint.setColorFilter(greenMatrixColorFilter);
        canvas.drawBitmap(bitmap, null, new RectF(400, 400*bitmap.getHeight()/bitmap.getWidth(), 800, 400*bitmap.getHeight()/bitmap.getWidth() * 2), paint);


        ColorMatrix blueColorMatrix = new ColorMatrix(new float[]{
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0,
        });
        ColorMatrixColorFilter blueMatrixColorFilter = new ColorMatrixColorFilter(blueColorMatrix);
        paint.setColorFilter(blueMatrixColorFilter);
        canvas.drawBitmap(bitmap, null, new RectF(800, 400*bitmap.getHeight()/bitmap.getWidth(), 1200, 400*bitmap.getHeight()/bitmap.getWidth() * 2), paint);
    }
}














