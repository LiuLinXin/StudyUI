package com.example.sober_philer.studyui.day33_cavas1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by philer on 2018/6/14.
 * Describe:
 */

public class ViewBackAnim extends View {

    int maxWidth = 50;//view的宽和高
    int iconWidth = 5;//绘制的横线的高度
    int marginLeft = 5;
    int marginTop = 8;
    int iconHeigh = 4;
    int iconMargin = (maxWidth - 3 * iconHeigh - 2 * marginTop) / 2;



//    private int iconSmallWidth =
    private int percent;
    private int maxRotate = 45;


    private Paint paint;
    public ViewBackAnim(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
//        paint.setStrokeWidth(dp2px(iconHeigh));
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

//        float trans =

        //上面的横线
        canvas.drawRoundRect(dp2px(marginLeft), dp2px(marginTop), dp2px(maxWidth - marginLeft), dp2px(marginTop + iconWidth), dp2px(1.5f), dp2px(1.5f), paint);
        //中间的横线
        canvas.drawRoundRect(dp2px(marginLeft), dp2px(marginTop + iconMargin + iconHeigh), dp2px(maxWidth - marginLeft), dp2px(marginTop + iconWidth + iconMargin + iconHeigh), dp2px(1.5f), dp2px(1.5f), paint);
        //下面的横线
        canvas.drawRoundRect(dp2px(marginLeft), dp2px(marginTop + 2 *(iconMargin + iconHeigh)), dp2px(maxWidth - marginLeft), dp2px(marginTop + iconWidth + 2 * (iconMargin + iconHeigh)), dp2px(1.5f), dp2px(1.5f), paint);
    }


    private float dp2px(float dp){
        return getResources().getDisplayMetrics().density * dp + 0.5f;
    }
}
