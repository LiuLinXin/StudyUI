package com.example.sober_philer.studyui.day12_tablayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2017/12/24.
 */

public class Day12ActivityTablayout extends AppCompatActivity {

    private TabLayout tabHead;
    private ViewPager vpContent;
    private String[] content = new String[]{
      "空调",
      "电脑桌",
      "电脑",
      "床",
      "书架",
      "衣柜",
      "书包",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day12);

        tabHead = findViewById(R.id.tabHead);
        vpContent = findViewById(R.id.vpContent);

        vpContent.setAdapter(new InnerAdapter(getSupportFragmentManager()));
        tabHead.setupWithViewPager(vpContent);
        int tabCount = tabHead.getTabCount();
        for(int i=0;i<tabCount;i++){
            TabLayout.Tab tabAt = tabHead.getTabAt(i);
            tabAt.setIcon(R.mipmap.im3);
        }
    }

    private class InnerAdapter extends FragmentPagerAdapter{

        public InnerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            OnePageFragment fragment = new OnePageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content", content[position]);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return content.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return content[position];
        }
    }
}
