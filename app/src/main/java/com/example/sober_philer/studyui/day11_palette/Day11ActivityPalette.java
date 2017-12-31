package com.example.sober_philer.studyui.day11_palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toolbar;

import com.example.sober_philer.studyui.R;

/**
 * Created by philer on 2017/12/20.
 */

public class Day11ActivityPalette extends AppCompatActivity implements PhilerScrollView.ScrollListener, View.OnClickListener {

    private PhilerScrollView scrollView;
    private android.support.v7.widget.Toolbar toolbar;
    private ViewPager vpContent;
    private ImageView ivIcon;
    private View idView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day11);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        scrollView = (PhilerScrollView) findViewById(R.id.scrollView);
        setSupportActionBar(toolbar);

        vpContent = (ViewPager) findViewById(R.id.vpContent);
        ivIcon = (ImageView) findViewById(R.id.ivIcon);
        findViewById(R.id.buNext).setOnClickListener(this);
        idView = findViewById(R.id.idView);
        scrollView.setScrollListener(this);
        vpContent.setAdapter(new InnerAdapter());

        BitmapDrawable drawable = (BitmapDrawable)ivIcon.getDrawable();
        final Bitmap bitmap = drawable.getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
                int rgb = lightMutedSwatch.getRgb();
                int titleTextColor = lightMutedSwatch.getTitleTextColor();
                int bodyTextColor = lightMutedSwatch.getBodyTextColor();

                int temp = palette.getLightMutedColor(Color.RED);
                int darkMutedColor;
                Color.argb(0,0,0,0);
                darkMutedColor = temp;
                int red = darkMutedColor >> 16 & 0B11111111;
                Color.red(darkMutedColor);
                darkMutedColor = temp;
                int green = darkMutedColor >> 8 & 0B11111111;
                darkMutedColor = temp;
                int blue = darkMutedColor & 0B11111111;
                Log.i("philer", "r : "+red);
                Log.i("philer", "g : "+green);
                Log.i("philer", "b : "+blue);


                int i = (125 << 24) ^ temp;
                idView.setBackgroundColor(i);
            }
        });
    }

    @Override
    public void scroll(float percent) {
        Log.i("philer", "percent : "+percent);
        toolbar.setAlpha(1 - percent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.buNext){
            startActivity(new Intent(this, Day11ActivityGridPalette.class));
        }
    }

    class InnerAdapter extends PagerAdapter{

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView ivIcon = new ImageView(container.getContext());
            ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
            layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewPager.LayoutParams.MATCH_PARENT;
            ivIcon.setLayoutParams(layoutParams);
            ivIcon.setScaleType(ImageView.ScaleType.FIT_XY);
            ivIcon.setPadding(30, 30, 30, 30);
            if(position % 2 == 0) {
                ivIcon.setBackgroundColor(Color.RED);
            }else{
                ivIcon.setBackgroundColor(Color.GRAY);
            }
            ivIcon.setImageResource(R.mipmap.ic_launcher);
            container.addView(ivIcon);
            return ivIcon;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
