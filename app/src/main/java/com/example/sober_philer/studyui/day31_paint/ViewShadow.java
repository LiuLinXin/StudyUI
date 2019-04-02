package com.commenframe.view.shadow;

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
//    RadialGradient radialGradient;
//    int startColor, endColor;

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
//        startColor = Color.RED;
//        endColor = startColor & 0x00FFFFFF;
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        if (shapPaint == null) {
//            radialGradient = new RadialGradient(getMeasuredHeight() / 2, getMeasuredHeight() / 2,
//                    getMeasuredHeight() / 2, startColor, endColor, Shader.TileMode.CLAMP);
//            shapPaint.setShader(radialGradient);
//        }
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, shapPaint);
    }
}
