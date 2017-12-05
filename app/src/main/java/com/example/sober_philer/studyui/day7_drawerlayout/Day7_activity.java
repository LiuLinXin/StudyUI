package com.example.sober_philer.studyui.day7_drawerlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2017/12/4.
 * description:
 */

public class Day7_activity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    private DrawerLayout drawerLayout;
    private View llContent, llDrawer;
    int width;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7_activity);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        llContent = findViewById(R.id.llContent);
        llDrawer = findViewById(R.id.llDrawer);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();

        ViewGroup.LayoutParams layoutParams = llDrawer.getLayoutParams();
        layoutParams.width = (int) (width * 0.8);
        llDrawer.setLayoutParams(layoutParams);
        drawerLayout.addDrawerListener(this);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Log.i("philer", "slide : "+slideOffset);
        Log.i("philer", "setTranslationX : "+((float) (width * 0.8 * slideOffset)));
        llContent.setTranslationX((float) (width * 0.8 * slideOffset));
        llDrawer.setTranslationX((float) (width * 0.8 * (1 - slideOffset) / 2));
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
