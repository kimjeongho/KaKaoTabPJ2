package com.example.kimjh.kakaotabpj.tabview;

import android.content.Context;
import android.widget.FrameLayout;

import com.example.kimjh.kakaotabpj.R;

/**
 * Created by kimjh on 2016-02-14.
 */
public class Tabview_setting extends FrameLayout {
    public Tabview_setting(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.tab_setting,this);
    }
}
