package com.example.sober_philer.studyui.day23_svg;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/27.
 * description:
 */

public class Day23Activity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day23_activity);
        findViewById(R.id.ivAnim).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        ImageView imageView = (ImageView) v;
        Drawable drawable = imageView.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable) drawable).start();
        }
    }
}
