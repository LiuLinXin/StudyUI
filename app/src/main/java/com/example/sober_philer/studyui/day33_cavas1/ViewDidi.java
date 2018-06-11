package com.example.sober_philer.studyui.day33_cavas1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

/**
 * Created by 39716 on 2018/6/10.
 */

public class ViewDidi extends View {
    Paint paint = new Paint();
    int nowPercent = 0;//当前的进度 - 直线是100， 曲线是200;

    public ViewDidi(Context context) {
        super(context);
        paint.setColor(Color.argb(255, 235, 138, 24));
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(100, 100);
        if(nowPercent < 100) {
            canvas.drawLine(100 - nowPercent,0,100,0, paint);
        }else {
            canvas.drawLine(0, 0, 100, 0, paint);

            int tempPercent = nowPercent - 100;

            int sweepAngle = (int) (1f * tempPercent * 180 / 200);
            int startAngle = 180 - sweepAngle;
            Log.i("philerTest", "startangle : "+startAngle+"  sweepAngle : "+sweepAngle );
            RectF rectF = new RectF(10, -60, 110, 70);
            canvas.drawArc(rectF, startAngle, sweepAngle, false, paint);
        }

        nowPercent++;
        if(nowPercent > 300){
            nowPercent = 0;
        }
        postInvalidateDelayed(10);
    }
}
