package com.example.sober_philer.studyui.day11_palette;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sober_philer.studyui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 39716 on 2017/12/24.
 */

public class Day11ActivityGridPalette extends Activity {

    private RecyclerView vpContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day11_grid);
        vpContent = findViewById(R.id.vpContent);
        vpContent.setLayoutManager(new GridLayoutManager(this, 2));
        vpContent.setAdapter(new InnerAdapter());
    }

    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.InnerHolder>{

        @Override
        public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.day11_item, parent, false);
            return new InnerHolder(inflate);
        }

        @Override
        public void onBindViewHolder(final InnerHolder holder, int position) {
            int id = getResources().getIdentifier("im" + (position + 1), "mipmap", getPackageName());
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
            holder.ivIcon.setImageBitmap(bitmap);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    Palette.Swatch darkMutedSwatch = null;
                    darkMutedSwatch = palette.getDarkMutedSwatch();
                    if(darkMutedSwatch == null){
                        darkMutedSwatch = palette.getDarkVibrantSwatch();
                    }
                    if(darkMutedSwatch == null){
                        darkMutedSwatch = palette.getLightMutedSwatch();
                    }
                    int rgb = darkMutedSwatch.getRgb();
                    int titleTextColor = darkMutedSwatch.getTitleTextColor();
                    holder.tvText.setTextColor(titleTextColor);
                    holder.tvText.setBackgroundColor(getTransColor(0.7f, rgb));
                }
            });
        }

        private int getTransColor(float trans, int color){
            int red = color >>> 16 & 0xff;
            int green = color >>> 8 & 0xff;
            int blue = color & 0xff;
            int alpha = color >>> 24;
            return Color.argb((int)(alpha * trans), red, green, blue);
        }

        @Override
        public int getItemCount() {
            return 7;
        }

        class InnerHolder extends RecyclerView.ViewHolder{
            private ImageView ivIcon;
            private TextView tvText;
            public InnerHolder(View itemView) {
                super(itemView);
                ivIcon = itemView.findViewById(R.id.ivIcon);
                tvText = itemView.findViewById(R.id.tvText);
            }
        }
    }
}
