package com.example.kimjh.kakaotabpj;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kimjh on 2016-02-09.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FriendFragment tab1 = new FriendFragment();
                return tab1;
            case 1:
                ChattingFragment tab2 = new ChattingFragment();
                return tab2;
            case 2:
                ChannelFragment tab3 = new ChannelFragment();
                return tab3;
            case 3:
                SettingFragment tab4 = new SettingFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "친구";
            case 1:
                return "채팅";
            case 2:
                return "채널";
            case 3:
                return "더보기";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
