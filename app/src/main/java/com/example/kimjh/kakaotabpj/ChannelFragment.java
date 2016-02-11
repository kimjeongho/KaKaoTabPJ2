package com.example.kimjh.kakaotabpj;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelFragment extends Fragment {

    RecyclerView recyclerView;
    ChannelAdapter mAdapter;

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



    public ChannelFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true); //자신의 Fragment에만 해당 Menu가 나옴
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_channel, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        mAdapter = new ChannelAdapter();
        recyclerView.setAdapter(mAdapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(mAdapter.getItemViewType(position) == ChannelAdapter.VIEW_TYPE_GROUP){
                    return 2;
                }
                return 1;
            }
        });

        recyclerView.setLayoutManager(layoutManager);

        initData();

        return v;
    }

    private void initData() {
        String[] items = getResources().getStringArray(R.array.channel_item);
        for (int i=0; i<1; i++){
            for (int j=0; j<ICON_IDS.length; j++){
                ChannelItemData id = new ChannelItemData();
                id.iconId = ICON_IDS[j];
                id.titleView =items[j];
                //cd.iconId=R.mipmap.ic_launcher;
                mAdapter.put("더보기",id);
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("채널");   // ActionBar(ToolBar)설정
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_channel, menu);    // Menu설정
    }
}
