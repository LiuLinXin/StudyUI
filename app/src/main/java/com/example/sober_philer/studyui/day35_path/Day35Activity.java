package com.example.sober_philer.studyui.day35_path;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by philer on 2018/7/2.
 * Describe:
 */
public class Day35Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewWave viewWave = new ViewWave(this);
        setContentView(viewWave);
    }
}
