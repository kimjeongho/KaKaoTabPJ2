package com.example.kimjh.kakaotabpj.friend;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.R;

/**
 * Created by kimjh on 2016-02-09.
 */
public class FriendGroupView extends FrameLayout {

    public FriendGroupView(Context context) {
        super(context);
        init();
    }

    TextView FriendGroupView;
    FriendGroupData item;

    private void init() {
        inflate(getContext(), R.layout.friend_group,this);
        FriendGroupView = (TextView)findViewById(R.id.text_group);
    }

    public void setFriendGroupData(FriendGroupData item){
        this.item = item;
        FriendGroupView.setText(item.FriendGroupName);
    }
}
