package com.example.sober_philer.studyui.day24_animfram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by sober_philer on 2018/4/28.
 * description:
 */

public class ViewAnimal extends FrameLayout {

    ViewFramContent.AnimalLayoutParmas beforViewParmas;
    public boolean alphaAnim, scalAnim, transXAnim;

    public ViewAnimal(@NonNull Context context) {
        super(context);
    }

    public ViewAnimal(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setBeforViewParmas(ViewFramContent.AnimalLayoutParmas beforViewParmas) {
        this.beforViewParmas = beforViewParmas;
        alphaAnim = beforViewParmas.alphaAnim;
        scalAnim = beforViewParmas.scalAnim;
        transXAnim = beforViewParmas.transXAnim;
    }

    public void notShow(){//还没有显示

    }

    public void showing(float percent){//正在显示
        if(alphaAnim) {
            setAlpha(percent);
        }
        if(scalAnim){
            setScaleX(percent);
            setScaleY(percent);
        }
        if(transXAnim){
            setTranslationX(getWidth() * (1 - percent));
        }
    }

    public void showOver(){//已经完全完成
        if(alphaAnim) {
            setAlpha(1);
        }
        if(scalAnim){
            setScaleX(1);
            setScaleY(1);
        }
        if(transXAnim){
            setTranslationX(0);
        }
    }
}
