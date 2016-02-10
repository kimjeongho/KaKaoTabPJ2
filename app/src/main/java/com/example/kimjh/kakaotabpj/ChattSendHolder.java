package com.example.kimjh.kakaotabpj;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChattSendHolder extends RecyclerView.ViewHolder {
    TextView messageView;
    ImageView iconView;
    ChattSendData data;

    public ChattSendHolder(View itemView) {
        super(itemView);
        iconView = (ImageView)itemView.findViewById(R.id.image_send);
        messageView = (TextView)itemView.findViewById(R.id.text_send);
    }

    public void setData(ChattSendData data) {
        this.data = data;
        messageView.setText(data.message);
        iconView.setImageResource(data.iconId);
    }
}
