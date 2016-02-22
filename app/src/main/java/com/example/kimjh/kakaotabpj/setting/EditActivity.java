package com.example.kimjh.kakaotabpj.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kimjh.kakaotabpj.R;

public class EditActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "my_prefs";
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    EditText profileEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);    //객체 획득
        mEditor = mPrefs.edit();

        profileEdit = (EditText)findViewById(R.id.edit_profile);
        Button btn = (Button)findViewById(R.id.btn_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String profile = profileEdit.getText().toString();
                PropertyManager.getInstance().setProfile(profile);

                finish();
            }
        });
        profileEdit.setText(PropertyManager.getInstance().getProfile());
    }
}
