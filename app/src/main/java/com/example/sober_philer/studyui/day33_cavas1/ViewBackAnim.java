package com.example.sober_philer.studyui.day33_cavas1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
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

    private boolean jiantouTrans = true;

    public ViewBackAnim(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
//        paint.setStrokeWidth(dp2px(iconHeigh));
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                jiantouTrans = !jiantouTrans;
                if(jiantouTrans){
//                    percent = 0;
                    postInvalidate();
                }else {
//                    percent = 100;
                    postInvalidate();
                }
            }
        });

        int i = -3;
        Log.i("philerTest", i / 10+"");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Log.i("philerTest", "onDraw : "+percent);
        canvas.save();

        float transX = 1f * percent / 100 * 0.25f * maxWidth;
        float centerTransX = 1f * percent / 100 * 0.15f * maxWidth;
        float transY = 1f * percent / 100 * 2.5f * iconWidth;
        float rotate = 1f * percent / 100 * 45;
        float small = 1 - 1f * percent / 100 * 0.25f;

        //上面的横线
        canvas.translate(-transX, transY);
        canvas.rotate(-rotate, (dp2px(marginLeft) + dp2px(maxWidth - marginLeft)) / 2, (dp2px(marginTop) + dp2px(marginTop + iconWidth)) / 2);
        canvas.scale(small, 1, (dp2px(marginLeft) + dp2px(maxWidth - marginLeft)) / 2, (dp2px(marginTop) + dp2px(marginTop + iconWidth)) / 2);
        canvas.drawRoundRect(dp2px(marginLeft), dp2px(marginTop), dp2px(maxWidth - marginLeft), dp2px(marginTop + iconWidth), dp2px(1.5f), dp2px(1.5f), paint);
        //中间的横线
        canvas.restore();
        canvas.save();
        canvas.translate(centerTransX, 0);
        canvas.drawRoundRect(dp2px(marginLeft), dp2px(marginTop + iconMargin + iconHeigh), dp2px(maxWidth - marginLeft), dp2px(marginTop + iconWidth + iconMargin + iconHeigh), dp2px(1.5f), dp2px(1.5f), paint);
        //下面的横线
        canvas.restore();
        canvas.save();
        canvas.translate(-transX, -transY);
        canvas.rotate(rotate, (dp2px(marginLeft) + dp2px(maxWidth - marginLeft)) / 2,
                (dp2px(marginTop + 2 * (iconMargin + iconHeigh)) + dp2px(marginTop + iconWidth + 2 * (iconMargin + iconHeigh))) / 2);
        canvas.scale(small, 1, (dp2px(marginLeft) + dp2px(maxWidth - marginLeft)) / 2,
                (dp2px(marginTop + 2 * (iconMargin + iconHeigh)) + dp2px(marginTop + iconWidth + 2 * (iconMargin + iconHeigh))) / 2);
        canvas.drawRoundRect(dp2px(marginLeft), dp2px(marginTop + 2 * (iconMargin + iconHeigh)), dp2px(maxWidth - marginLeft), dp2px(marginTop + iconWidth + 2 * (iconMargin + iconHeigh)), dp2px(1.5f), dp2px(1.5f), paint);


        canvas.restore();

        if(jiantouTrans){
            percent += 3;
            if(percent <= 100){
                postInvalidate();
            }
        }else {
            percent-=3;
            if(percent>=0){
                postInvalidate();
            }
        }
    }


    private float dp2px(float dp) {
        return getResources().getDisplayMetrics().density * dp + 0.5f;
    }
}
