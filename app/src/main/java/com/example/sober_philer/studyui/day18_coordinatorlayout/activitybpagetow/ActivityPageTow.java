package com.example.sober_philer.studyui.day18_coordinatorlayout.activitybpagetow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toolbar;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2018/4/10.
 */
public class ActivityPageTow extends AppCompatActivity {

    private CoordinatorLayout coordinator;
    private AppBarLayout appBar;
    private CollapsingToolbarLayout collapsing_toolbar;
    private android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day18pagetow);
        coordinator = findViewById(R.id.coordinator);
        appBar = findViewById(R.id.appBar);
        collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        toolbar = findViewById(R.id.toolbar);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i("philerTest", "verticalOffset : "+verticalOffset);
                Log.i("philerTest", "appBarLayout height : "+(appBarLayout.getHeight() - toolbar.getHeight()));
            }
        });
    }
}
