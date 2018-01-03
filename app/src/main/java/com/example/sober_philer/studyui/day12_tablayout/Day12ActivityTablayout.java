package com.example.sober_philer.studyui.day12_tablayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

/**
 * Created by 39716 on 2017/12/24.
 */

public class Day12ActivityTablayout extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private TabLayout tabHead;
    private ViewPager vpContent;
    private LinearLayout llText;
    private String[] content = new String[]{
      "空调",
      "电脑桌",
      "电脑",
      "床",
//      "书架",
//      "衣柜",
//      "书包",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day12);

        tabHead = findViewById(R.id.tabHead);
        vpContent = findViewById(R.id.vpContent);
        llText = findViewById(R.id.llText);

        vpContent.setAdapter(new InnerAdapter(getSupportFragmentManager()));
        tabHead.addTab(tabHead.newTab().setCustomView(R.layout.day12_tabcustomview));
        tabHead.setupWithViewPager(vpContent);
        int tabCount = tabHead.getTabCount();
        for(int i=0;i<tabCount;i++){
            TabLayout.Tab tabAt = tabHead.getTabAt(i);
//            tabAt.setCustomView(R.layout.day12_tabcustomview);
            tabAt.setIcon(R.mipmap.im3);
        }
        tabHead.requestLayout();
        vpContent.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i("philer","onpage : "+position +"   : "+positionOffset+"  : "+positionOffsetPixels);
        int tabCount = tabHead.getTabCount();
        for(int i=0;i<tabCount;i++){
            TabLayout.Tab tabAt = tabHead.getTabAt(i);
            if(i == position){
                setTextColor((TextView) llText.getChildAt(i), 1 - positionOffset);
            }else if(i == position+1 && positionOffset != 0){
                setTextColor((TextView) llText.getChildAt(i), positionOffset);
            }else {
                setTextColor((TextView) llText.getChildAt(i), 0);
            }
        }
    }

    private void setTextColor(TextView textView, float selected){
        if(textView == null){
            return;
        }
        int color = Color.argb(255, (int)(255 * selected), 0, 0);
        textView.setTextColor(color);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

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
