package com.example.kimjh.kakaotabpj.friend;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.R;

/**
 * Created by kimjh on 2016-02-09.
 */
public class FriendChildView extends FrameLayout {

    public FriendChildView(Context context) {
        super(context);
        init();
    }

    TextView FriendChildView;
    ImageView FriendIconView;
    FriendChildData item;
    private void init() {

        inflate(getContext(), R.layout.friend_child,this);
        FriendChildView = (TextView)findViewById(R.id.text_child);
        FriendIconView = (ImageView)findViewById(R.id.imageView);
    }

    public void setFriendChildData(FriendChildData item) {
        this.item = item;
        FriendChildView.setText(item.friendChildName);
        FriendIconView.setImageResource(item.friendIconId);
    }
}
