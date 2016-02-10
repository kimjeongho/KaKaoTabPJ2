package com.example.kimjh.kakaotabpj;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kimjh on 2016-02-09.
 */
public class ChattingListView extends FrameLayout{
    public ChattingListView(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView nameView, descView;
    ChattingListData mData;

    private void init() {
        inflate(getContext(),R.layout.chattinglist_item,this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        descView = (TextView)findViewById(R.id.text_description);

    }

    public void setChattingList(ChattingListData data){
        this.mData = data;
        iconView.setImageResource(data.iconId);
        nameView.setText(data.name);
        descView.setText(data.desc);
    }
}
