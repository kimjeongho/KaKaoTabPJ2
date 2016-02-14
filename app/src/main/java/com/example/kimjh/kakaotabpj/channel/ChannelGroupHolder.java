package com.example.kimjh.kakaotabpj.channel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.R;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChannelGroupHolder extends RecyclerView.ViewHolder {
    TextView titleView;

    public ChannelGroupHolder(View itemView) {
        super(itemView);
        titleView = (TextView)itemView.findViewById(R.id.text_group);
    }

    public void setGroupItem(ChannelGroupData group) {
        titleView.setText(group.groupName);
    }
}
