package com.example.kimjh.kakaotabpj.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by dongja94 on 2016-02-11.
 */
public class PropertyManager {
    private static PropertyManager instance;
    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private static final String FIELD_USER_NAME = "username";
    private static final String FIELD_USER_PROFILE = "userprofile";

    private PropertyManager() {
        Context context = MyApplication.getContext();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();
    }

    public void setUserName(String userid) {
        mEditor.putString(FIELD_USER_NAME, userid);
        mEditor.commit();
    }

    public String getUserName() {
        return mPrefs.getString(FIELD_USER_NAME,"");
    }

    public void setProfile(String password) {
        mEditor.putString(FIELD_USER_PROFILE, password);
        mEditor.commit();
    }

    public String getProfile() {
        return mPrefs.getString(FIELD_USER_PROFILE, "");
    }


}
