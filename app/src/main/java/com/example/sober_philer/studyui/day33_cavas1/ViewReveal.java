package com.example.sober_philer.studyui.day33_cavas1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by philer on 2018/6/13.
 * Describe:
 */

public class ViewReveal extends View {

    private Bitmap bitmap1;
    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private int opStart, opEnd;

    public ViewReveal(Context context, int mipmap) {
        super(context);
        bitmap1 = BitmapFactory.decodeResource(getResources(), mipmap);
        Matrix matrix = new Matrix();
        matrix.setScale(0.4f, 0.4f);
        bitmap1 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), bitmap1.getHeight(), matrix, true);
        BitmapShader bitmapShader = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        paint2.setShader(bitmapShader);
        float[] colorMatrix = new float[]{
                -1, 0, 0, 0, 255,
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 255,
        };
        paint2.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }


    public void setOpRegion(int start, int end){
        opStart = start;
        opEnd = end;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

//        Path path = new Path();
//        path.addRect(0, 0, bitmap1.getWidth() / 2, bitmap1.getHeight(), Path.Direction.CCW);
//        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.drawBitmap(bitmap1, 0, 0, paint);
//        canvas.restore();


        if(opStart != 0 || opEnd != 0) {
            Path path1 = new Path();
            path1.addRect(opStart, 0, opEnd, canvas.getHeight(), Path.Direction.CCW);
            canvas.clipPath(path1, Region.Op.REPLACE);
            canvas.drawBitmap(bitmap1, 0, 0, paint2);
            canvas.restore();
        }

//
//        Region region = new Region(0,0,bitmap1.getWidth(), bitmap1.getHeight());
//
//        Rect rect = new Rect();
//        RegionIterator regionIterator = new RegionIterator(region);
//        while (regionIterator.next(rect)){
//            canvas.drawRect(rect, paint);
//        }
    }
}
