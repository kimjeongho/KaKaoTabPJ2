package com.example.kimjh.kakaotabpj.chatting;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kimjh.kakaotabpj.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChattingFragment extends Fragment {


    public ChattingFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }
    ListView listView;
    ChattingListAdapter mAdapter;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chatting, container, false);

        View header = inflater.inflate(R.layout.chatting_search,null);

        listView = (ListView)v.findViewById(R.id.listView);

        listView.addHeaderView(header,null,false);

        mAdapter = new ChattingListAdapter();
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChattingListData mData = (ChattingListData) listView.getItemAtPosition(position);
                Toast.makeText(getContext(), "name: " + mData.name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),ChattingActivity.class);
                //----------------------값 전달(Activity) 하기-----------------------------------------------
                String input = mData.name;
                int iconImage = mData.iconId;
                intent.putExtra(ChattingActivity.PARAM_INPUT_MESSAGE, input);
                intent.putExtra(ChattingActivity.PARAM_INPUT_IMAGE, iconImage);
                //----------------------값 전달(Activity) 하기-----------------------------------------------
                startActivity(intent);
            }
        });
        initData();
        return v;
    }

    private void initData() {
        for (int i = 0 ; i < NAMES.length ; i++) {
            ChattingListData cd = new ChattingListData();
            cd.iconId = ICON_IDS[i];
            cd.name = NAMES[i];
            mAdapter.add(cd);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("채팅");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_chatting, menu);
    }
}
