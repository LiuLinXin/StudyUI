package com.example.sober_philer.studyui.day24_animfram;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by sober_philer on 2018/4/28.
 * description:
 */

public class ViewFramScroll extends ScrollView {


    public ViewFramScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        View childAt = getChildAt(0);
        if(!(childAt instanceof ViewFramContent)){
            return;
        }
        int nowT = t + getHeight();
        ViewFramContent viewFramContent = (ViewFramContent) childAt;
        int childCount = viewFramContent.getChildCount();
        for (int i=0;i<childCount;i++){
            View childAt1 = viewFramContent.getChildAt(i);
            if(!(childAt1 instanceof ViewAnimal)){
                continue;
            }
            ViewAnimal viewAnimal = (ViewAnimal) childAt1;
            int height = viewAnimal.getHeight();
            int top = viewAnimal.getTop();
            int scrollY = nowT - top;
            if(scrollY < 0){//还没有显示出来
                viewAnimal.notShow();
            }else if(scrollY > height){//已经完全滑出来了
                viewAnimal.showOver();
            }else {//滑出来一部分
                viewAnimal.showing(1f * scrollY / height);
            }
        }
    }
}
