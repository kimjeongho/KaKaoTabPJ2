package com.example.kimjh.kakaotabpj.friend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.kimjh.kakaotabpj.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {

    ExpandableListView listView;
    FriendAdapter mAdapter;

    static  final int[] ICON_IDS = {
            R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6,
            R.drawable.gallery_photo_7,
            R.drawable.gallery_photo_8
    };

    static  final String[] NAMES = {"이영석","김청환","정회군","김재원","구병모","조성관","조성현","이정환"
    };

    public FriendFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_friend, container, false);
        View search = inflater.inflate(R.layout.friend_search, null);
        View myProfileGroup = inflater.inflate(R.layout.friend_group_myprofile, null);
        View myProgileChild = inflater.inflate(R.layout.friend_child_myprofile, null);
        View adGroup = inflater.inflate(R.layout.friend_group_ad, null);
        View adChild = inflater.inflate(R.layout.friend_child_ad, null);

        listView = (ExpandableListView)v.findViewById(R.id.expandableListView);
        //Header자리.............
        listView.addHeaderView(search,null,false);
        listView.addHeaderView(myProfileGroup,null,false);
        listView.addHeaderView(myProgileChild,null,false);
        listView.addHeaderView(adGroup,null,false);
        listView.addHeaderView(adChild,null,false);

        mAdapter = new FriendAdapter();
        listView.setAdapter(mAdapter);
        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                listView.expandGroup(groupPosition);
            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getContext(), "child" + childPosition, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        initData();

        for (int i=0; i < mAdapter.getGroupCount(); i++){
            listView.expandGroup(i);
        }
        return v;
    }

    private void initData() {
        for (int i=0; i<1; i++){
            for (int j=0; j<ICON_IDS.length; j++){
                FriendChildData cd = new FriendChildData();
                cd.friendChildName= NAMES[j];
                cd.friendIconId = ICON_IDS[j];
                //cd.iconId=R.mipmap.ic_launcher;
                mAdapter.put("친구", cd);
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("친구");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_friend, menu);
    }
}
