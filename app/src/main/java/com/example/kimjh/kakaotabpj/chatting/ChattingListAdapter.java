package com.example.kimjh.kakaotabpj.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by kimjh on 2016-02-09.
 */
public class ChattingListAdapter extends BaseAdapter {
    ArrayList<ChattingListData> items = new ArrayList<ChattingListData>();

    public ChattingListAdapter(){

    }

    public void add(ChattingListData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChattingListView view;
        if(convertView == null){
            view = new ChattingListView(parent.getContext());
        } else {
            view = (ChattingListView)convertView;
        }
        view.setChattingList(items.get(position));
        return view;
    }
}
