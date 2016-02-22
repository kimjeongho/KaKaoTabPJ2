package com.example.kimjh.kakaotabpj.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.R;

public class ProfileActivity extends AppCompatActivity {

    TextView nameView,profileView;

    private static final String PREFS_NAME = "my_prefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        setSupportActionBar((Toolbar) findViewById(R.id.main_toolbar));
        setTitle("내 프로필 관리");

        /*ImageView riv = (ImageView)findViewById(R.id.image_icon);
        Bitmap bm = ((BitmapDrawable)getResources().getDrawable(R.drawable.a1443687949897)).getBitmap();
        riv.setImageBitmap(bm);*/

        nameView = (TextView)findViewById(R.id.text_name);
        profileView = (TextView)findViewById(R.id.text_profile);

        nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, NameActivity.class);
                startActivity(intent);
            }
        });

        profileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameView.setText(PropertyManager.getInstance().getUserName());
        profileView.setText(PropertyManager.getInstance().getProfile());
    }
}
