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

public class NameActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "my_prefs";
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    EditText nameEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mPrefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);    //객체 획득
        mEditor = mPrefs.edit();

        nameEdit = (EditText)findViewById(R.id.edit_name);
        Button btn = (Button)findViewById(R.id.btn_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                PropertyManager.getInstance().setUserName(name);
                Intent intent = new Intent(NameActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
        nameEdit.setText(PropertyManager.getInstance().getUserName());
    }
}
