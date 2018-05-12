package com.example.sober_philer.studyui.day24_animfram;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/28.
 * description:
 */

public class ViewFramContent extends LinearLayout {
    public ViewFramContent(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new AnimalLayoutParmas(getContext(), attrs);
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        AnimalLayoutParmas animalLayoutParmas = (AnimalLayoutParmas) params;
        if(!checkAdd(animalLayoutParmas)){
            super.addView(child, index, params);
            return;
        }
        ViewAnimal viewAnimal = new ViewAnimal(getContext());
        viewAnimal.setBeforViewParmas(animalLayoutParmas);
        viewAnimal.addView(child);
        super.addView(viewAnimal, index, params);
    }

    private boolean checkAdd(AnimalLayoutParmas animalLayoutParmas){
        if(animalLayoutParmas.alphaAnim || animalLayoutParmas.scalAnim || animalLayoutParmas.transXAnim){
            return true;
        }
        return false;
    }

    public static class AnimalLayoutParmas extends LinearLayout.LayoutParams{

        public boolean alphaAnim, scalAnim, transXAnim;

        public AnimalLayoutParmas(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable.viewAnim);
            alphaAnim = typedArray.getBoolean(R.styleable.viewAnim_alphaAnim, false);
            scalAnim = typedArray.getBoolean(R.styleable.viewAnim_scalAnim, false);
            transXAnim = typedArray.getBoolean(R.styleable.viewAnim_transXAnim, false);
        }
    }
}
