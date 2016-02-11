package com.example.kimjh.kakaotabpj;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimjh on 2016-02-10.
 */
public class ChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ChannelGroupData> items = new ArrayList<ChannelGroupData>();

    public void put(String groupName, ChannelItemData channelItemData){
        ChannelGroupData group= null;
        for (ChannelGroupData g : items){
            if (g.groupName.equals(groupName)){
                group = g;
                break;
            }
        }
        if (group == null){
            group = new ChannelGroupData();
            group.groupName = groupName;
            items.add(group);
        }
        if (channelItemData != null){
            ChannelItemData child = new ChannelItemData();
            child.titleView = channelItemData.titleView;
            child.iconId = channelItemData.iconId;
            group.children.add(child);
        }
        notifyDataSetChanged();
    }

    public static final int VIEW_TYPE_GROUP = 0;
    public static final int VIEW_TYPE_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        for (int i = 0 ; i < items.size() ; i++){
            ChannelGroupData group = items.get(i);
            int itemCount = group.children.size();

            if(position < itemCount) return VIEW_TYPE_ITEM;
            position -= itemCount;

            if(position < 1)return VIEW_TYPE_GROUP;
            position --;
        }
        return super.getItemViewType(position);
    }       //???

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); //??
        View view;
        switch (viewType){
            case VIEW_TYPE_ITEM:
                view = inflater.inflate(R.layout.channel_item, parent, false);
                return new ChannelItemHolder(view);
            case VIEW_TYPE_GROUP:
                view = inflater.inflate(R.layout.channel_group, parent, false);
                return new ChannelGroupHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        for (int i = 0 ; i < items.size() ; i++){
            ChannelGroupData g = items.get(i);
            int itemCount = g.children.size();
            if(position < itemCount) {
                ChannelItemData itemData = g.children.get(position);
                ((ChannelItemHolder)holder).setItem(itemData);
                return;
            }
            position -= itemCount;
            if(position < 1){
                ((ChannelGroupHolder)holder).setGroupItem(g);
                return;
            }
            position --;

        }
    }

    @Override
    public int getItemCount() {
        int totalCount = 0;
        for (ChannelGroupData g : items){
            totalCount += (1 + g.children.size());
        }

        return totalCount;
    }
}
