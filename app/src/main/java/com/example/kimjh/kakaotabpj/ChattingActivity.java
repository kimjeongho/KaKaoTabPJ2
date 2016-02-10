package com.example.kimjh.kakaotabpj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Date;

public class ChattingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EditText inputView;
    ChattingAdapter mAdapter;
    RadioGroup categoryView;

    //----------------결과 전달 하기--------------------------------------------------------------
    public static final String PARAM_INPUT_MESSAGE = "input_message";
    public static final String PARAM_INPUT_IMAGE = "input_Image";
    //----------------결과 전달 하기--------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        setSupportActionBar((Toolbar) findViewById(R.id.main_toolbar));
        inputView = (EditText)findViewById(R.id.editText);
        categoryView = (RadioGroup)findViewById(R.id.radio_group);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false); // ??
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ChattingAdapter();
        recyclerView.setAdapter(mAdapter);

        //----------------결과 전달 받기--------------------------------------------------------------
        Intent intent = getIntent();
        String message = intent.getStringExtra(PARAM_INPUT_MESSAGE);
        final int iconImage = intent.getExtras().getInt(PARAM_INPUT_IMAGE);
        setTitle(message);
        //----------------결과 전달 받기--------------------------------------------------------------

        Button btn  = (Button)findViewById(R.id.btn_push);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = categoryView.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radio_receive:
                        ChattReceiveData rd = new ChattReceiveData();
                        rd.iconId = iconImage;
                        rd.message = inputView.getText().toString();
                        mAdapter.add(rd);
                        break;

                    case R.id.radio_send:
                        ChattSendData sd = new ChattSendData();
                        sd.iconId = R.mipmap.ic_launcher;
                        sd.message = inputView.getText().toString();
                        mAdapter.add(sd);
                        break;

                    case R.id.radio_date:
                        ChattDateData dd = new ChattDateData();
                        dd.message = new Date().toString();
                        mAdapter.add(dd);
                        break;
                }

                inputView.setText("");
                recyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
            }
        });

    }
}
