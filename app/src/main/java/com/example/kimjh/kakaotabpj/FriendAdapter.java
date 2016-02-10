package com.example.kimjh.kakaotabpj;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimjh on 2016-02-09.
 */
public class FriendAdapter extends BaseExpandableListAdapter{
    List<FriendGroupData> items = new ArrayList<FriendGroupData>();

    public void put(String groupName, FriendChildData childData){
        FriendGroupData match = null;
        for (FriendGroupData g : items){
            if(g.FriendGroupName.equals(groupName)){
                match = g;
                break;
            }
        }
        if(match == null){
            match = new FriendGroupData();
            match.FriendGroupName = groupName;
            items.add(match);
        }
        if(childData != null){
            FriendChildData child = new FriendChildData();
            child.friendChildName = childData.friendChildName;
            child.friendIconId = childData.friendIconId;
            match.children.add(child);
        }
        notifyDataSetChanged();
    }



    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return ((long)groupPosition)<<32|0xFFFFFFFF;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return ((long)groupPosition)<<32|childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FriendGroupView view;
        if(convertView == null){
            view = new FriendGroupView(parent.getContext());
        } else {
            view = (FriendGroupView)convertView;
        }
        view.setFriendGroupData(items.get(groupPosition));

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        FriendChildView view;

        if(convertView == null){
            view = new FriendChildView(parent.getContext());
        } else {
            view = (FriendChildView)convertView;
        }
        view.setFriendChildData(items.get(groupPosition).children.get(childPosition));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
