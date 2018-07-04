package com.example.sober_philer.studyui.day34_cavas2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by philer on 2018/6/27.
 * Describe:
 */

public class ActivityCavas2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(this);
        DrawableMy drawableMy = new DrawableMy();
        imageView.setImageDrawable(drawableMy);
        setContentView(imageView);
    }
}
