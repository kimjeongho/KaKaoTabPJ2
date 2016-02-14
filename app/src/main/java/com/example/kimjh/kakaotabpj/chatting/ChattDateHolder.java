package com.example.kimjh.kakaotabpj.chatting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.R;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChattDateHolder extends RecyclerView.ViewHolder {
    TextView messageView;
    ChattDateData data;

    public ChattDateHolder(View itemView) {
        super(itemView);
        messageView = (TextView)itemView.findViewById(R.id.text_date);
    }

    public void setData(ChattDateData data){
        this.data = data;
        messageView.setText(data.message);
    }
}
