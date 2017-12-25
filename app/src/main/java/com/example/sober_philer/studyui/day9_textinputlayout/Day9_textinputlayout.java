package com.example.sober_philer.studyui.day9_textinputlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.sober_philer.studyui.R;

/**
 * Created by sober_philer on 2017/12/9.
 * description:textinputlayout
 */

public class Day9_textinputlayout extends AppCompatActivity implements TextWatcher {

    private TextInputLayout textInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day9_textinputlayout);

        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputLayout.setCounterEnabled(true);
        textInputLayout.setCounterMaxLength(10);

        textInputLayout.getEditText().addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        String s1 = textInputLayout.getEditText().getText().toString();
        if(s1.contains("1")){
            textInputLayout.setError("不能包括1");
        }else {
            textInputLayout.setError(null);
        }
    }
}
