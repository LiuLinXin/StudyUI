package com.example.sober_philer.studyui.day33_cavas1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 39716 on 2018/6/10.
 */

public class ActivityCavas1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewCanvas viewCanvas = new ViewCanvas(this);
//        ViewDidi viewCanvas = new ViewDidi(this);
        setContentView(viewCanvas);
    }
}
