package com.example.sober_philer.studyui.day36_pathmeasure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by philer on 2018/7/3.
 * Describe:
 */
public class Day36Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPathMeasure viewPathMeasure = new ViewPathMeasure(this);
        setContentView(viewPathMeasure);
    }
}
