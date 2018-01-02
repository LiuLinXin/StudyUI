package com.example.sober_philer.studyui.day13_trans_h;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/1/2.
 */

public class Day13ActivityTrans extends AppCompatActivity implements View.OnClickListener {

    private boolean trans = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.day13_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.navigation2));
        }
        View view = findViewById(R.id.tvText);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if(trans) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }else {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            }
            trans = !trans;
        }
    }
}
