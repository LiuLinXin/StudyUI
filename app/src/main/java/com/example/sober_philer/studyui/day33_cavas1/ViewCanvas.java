package com.example.sober_philer.studyui.day33_cavas1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/6/10.
 */

public class ViewCanvas extends View {
    public ViewCanvas(Context context) {
        super(context);
        init();
    }

    public ViewCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    Bitmap bitmap;
    private void init(){
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.im4);
        Matrix matrix = new Matrix();
        matrix.setScale(0.4f, 0.4f);
        bitmap = Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.RED);
//        Paint paint = new Paint();

//        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        paint.setShader(bitmapShader);
//        RectF rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
//        canvas.drawRoundRect(rectF, 50, 50, paint);

//        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        canvas.drawLine(0, 0, 100, 100, paint);
//        float[] pts = {0, 0, 100, 100,
//                200, 200, 300, 300};
//        canvas.drawLines(pts, paint);
//
//        paint.setStrokeWidth(30);
//        canvas.drawPoint(500, 500, paint);

//        RectF rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
//        canvas.drawRoundRect(rectF, 50, 50, paint);

//        canvas.drawArc(rectF,0, 30, true, paint);
//
//        Path path = new Path();
//        path.moveTo(500, 500);
//        path.cubicTo(300, 800, 500, 1000, 800, 1200);//贝塞尔曲线
//        Region region = new Region();

//        canvas.drawPath(path, paint);


        RectF rectF = new RectF(300, 300, 1000,1000);
        Path path = new Path();
        path.addOval(rectF, Path.Direction.CCW);

        Region region = new Region(100, 100, 500, 500);
        Region region1 = new Region();

        region1.setPath(path, region);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        RegionIterator iterator = new RegionIterator(region1);
        Rect rect = new Rect();
        while (iterator.next(rect)){
            canvas.drawRect(rect, paint);
        }
    }
}
