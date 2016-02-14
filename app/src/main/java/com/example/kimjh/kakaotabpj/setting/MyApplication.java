package com.example.kimjh.kakaotabpj.setting;

import android.app.Application;
import android.content.Context;

/**
 * Created by kimjh on 2016-02-11.
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
