package com.example.sober_philer.studyui.day21_animator;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/25.
 * description:转场动画第二个界面
 */

public class Day21MatieralDesignTow extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day21matieraldesigntow);
//        Slide slide = new Slide();
//        slide.setDuration(1000);
//        getWindow().setExitTransition(slide);
//        getWindow().setEnterTransition(slide);
    }
}
