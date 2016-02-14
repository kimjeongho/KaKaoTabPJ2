package com.example.kimjh.kakaotabpj.channel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.R;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChannelItemHolder extends RecyclerView.ViewHolder {
    TextView titleView;
    ImageView iconView;

    public ChannelItemHolder(View itemView) {
        super(itemView);
        titleView = (TextView)itemView.findViewById(R.id.text_title);
        iconView = (ImageView)itemView.findViewById(R.id.image_icon);
    }

    public void setItem(ChannelItemData item){
        titleView.setText(item.titleView);
        iconView.setImageResource(item.iconId);
    }
}
