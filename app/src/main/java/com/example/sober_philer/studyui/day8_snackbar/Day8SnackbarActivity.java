package com.example.sober_philer.studyui.day8_snackbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2017/12/8.
 * Description:
 */

public class Day8SnackbarActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private View tvSnackbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day8_snackbar_activity);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigation = (NavigationView) findViewById(R.id.navigation);
        findViewById(R.id.tvChangeNavigation).setOnClickListener(this);
        findViewById(R.id.tvToast).setOnClickListener(this);
        findViewById(R.id.tvSnackbar).setOnClickListener(this);
        tvSnackbar = findViewById(R.id.tvSnackbar);
        navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.tvToast){
            Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.tvSnackbar){
            Snackbar.make(tvSnackbar, "xixixi", Snackbar.LENGTH_SHORT).show();
//            new PhilerSnackBar(tvSnackbar, "嘻嘻嘻嘻嘻嘻").show();
        }else if(id == R.id.tvChangeNavigation){
            boolean drawerOpen = drawerLayout.isDrawerOpen(navigation);
            if(drawerOpen){
                drawerLayout.closeDrawer(navigation);
            }else {
                drawerLayout.openDrawer(navigation);
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        CharSequence title = item.getTitle();
        Log.i("philer", title+"");
        return false;
    }
}
