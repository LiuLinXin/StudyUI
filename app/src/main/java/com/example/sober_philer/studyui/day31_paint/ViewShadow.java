package com.example.sober_philer.studyui.day31_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by philer on 2018/8/16.
 * Describe:阴影
 */
public class ViewShadow extends View {

    Paint shapPaint = new Paint();
    RadialGradient radialGradient;
    int startColor, endColor;

    public ViewShadow(Context context) {
        super(context);
        init();
    }

    public ViewShadow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewShadow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        startColor = Color.RED;
        endColor = startColor & 0x00FFFFFF;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (shapPaint == null) {
            radialGradient = new RadialGradient(getMeasuredWidth() / 2, getMeasuredHeight() / 2,
                    getMeasuredHeight() / 2, startColor, startColor, Shader.TileMode.CLAMP);
            shapPaint.setShader(radialGradient);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, shapPaint);


//        canvas.save();
//
//        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//
//        paint.setStrokeWidth(5);
//
//        paint.setTextSize(100);
//
//        this.setLayerType(View.LAYER_TYPE_SOFTWARE,paint);//设置为SOFTWARE才会实现阴影
//
//        paint.setShadowLayer(10,1,1, Color.BLUE);//偏移度很小时则变成发光字体
//
//        canvas.drawText("Android开发",100,100,paint);
//
//        canvas.restore();
//
//        paint.setShadowLayer(10,5,5,Color.G shapPaint.setColor(Color.TRANSPARENT);REEN);//如果想要取消阴影，则将Radius设为0即可

        shapPaint.setTextSize(100);
        shapPaint.setShadowLayer(300, 0, 0, Color.RED);
        shapPaint.setColor(Color.BLUE);
//        canvas.drawText("aidfjafs", 100, 100, shapPaint);
        canvas.drawRect(100, 100,getWidth()-100,getBottom()-100, shapPaint);
    }
}
