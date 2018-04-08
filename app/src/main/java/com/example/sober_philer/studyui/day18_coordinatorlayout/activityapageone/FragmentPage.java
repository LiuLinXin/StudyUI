package com.example.sober_philer.studyui.day18_coordinatorlayout.activityapageone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2018/4/8.
 * description:
 */

public class FragmentPage extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_day18_pageone, container, false);
    }
}
