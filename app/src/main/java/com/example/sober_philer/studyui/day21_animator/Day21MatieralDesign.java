package com.example.sober_philer.studyui.day21_animator;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/25.
 * description:MatieralDesign动画
 */

public class Day21MatieralDesign extends AppCompatActivity implements View.OnClickListener {

    private View buTrans;
    private View ivCircleShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day21activity_matieraldesign);
        buTrans = findViewById(R.id.buTrans);
        buTrans.setOnClickListener(this);
        ivCircleShow = findViewById(R.id.ivCircleShow);
        ivCircleShow.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.ivCircleShow){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(v, v.getWidth() / 2, v.getHeight() / 2, 0, (float) Math.hypot(v.getWidth() / 2, v.getHeight() / 2));
                circularReveal.setDuration(2000);
                circularReveal.setInterpolator(new AccelerateInterpolator());
                circularReveal.start();
            }
        }else if(id == R.id.buTrans){
//            startActivity(new Intent(this, Day21MatieralDesignTow.class));
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);


            //共享元素
//            Pair<View, String> img = Pair.create(ivCircleShow, "img");
//            Pair<View, String> text = Pair.create(buTrans, "text");
//            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, text, img);
//            startActivity(new Intent(this, Day21MatieralDesignTow.class), optionsCompat.toBundle());

            //转场动画
            Slide slide = new Slide();
            slide.setDuration(1000);
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
            startActivity(new Intent(this, Day21MatieralDesignTow.class), optionsCompat.toBundle());
        }
    }
}
