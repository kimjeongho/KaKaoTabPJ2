package com.example.kimjh.kakaotabpj;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChattReceiveHolder extends RecyclerView.ViewHolder {
    TextView messageView;
    ImageView iconView;
    ChattReceiveData data;

    public ChattReceiveHolder(View itemView) {
        super(itemView);
        iconView = (ImageView)itemView.findViewById(R.id.image_receive);
        messageView = (TextView)itemView.findViewById(R.id.text_receive);
    }

    public void setData(ChattReceiveData data) {
        this.data = data;
        messageView.setText(data.message);
        iconView.setImageResource(data.iconId);
    }
}
