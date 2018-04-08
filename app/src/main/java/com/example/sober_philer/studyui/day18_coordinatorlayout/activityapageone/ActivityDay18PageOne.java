package com.example.sober_philer.studyui.day18_coordinatorlayout.activityapageone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.sober_philer.studyui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sober_philer on 2018/4/8.
 * description:viewpager - fragment - tasblayout - 头部滑动隐藏
 */

public class ActivityDay18PageOne extends AppCompatActivity{

    private List<Fragment> fragmentList = new ArrayList<>();
    private TabLayout tabHead;
    private ViewPager vpContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day18pageone);
        tabHead = findViewById(R.id.tabHead);
        vpContent = findViewById(R.id.vpContent);

        fragmentList.add(new FragmentPage());
        fragmentList.add(new FragmentPage());
        fragmentList.add(new FragmentPage());
        fragmentList.add(new FragmentPage());
        fragmentList.add(new FragmentPage());
        fragmentList.add(new FragmentPage());
        fragmentList.add(new FragmentPage());

        vpContent.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabHead.setupWithViewPager(vpContent);
    }

    private class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return position+"-"+position;
        }
    }
}
