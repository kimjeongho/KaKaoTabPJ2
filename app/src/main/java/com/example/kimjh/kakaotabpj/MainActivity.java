package com.example.kimjh.kakaotabpj;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.kimjh.kakaotabpj.tabview.Tabview_channel;
import com.example.kimjh.kakaotabpj.tabview.Tabview_chatt;
import com.example.kimjh.kakaotabpj.tabview.Tabview_friend;
import com.example.kimjh.kakaotabpj.tabview.Tabview_setting;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    MyPagerAdapter mAdapter;
    TextView a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);        //첫 페이지를 tabLayout로 한다.
        setSupportActionBar((Toolbar) findViewById(R.id.main_toolbar)); // toolbar설정
        tabLayout = (TabLayout)findViewById(R.id.tab_layout); // tabLayout 찾기

        pager = (ViewPager)findViewById(R.id.pagerView);    //tabLayout내에 ViewPager를 가져 온다.
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(mAdapter);

        tabLayout.setupWithViewPager(pager); //TabLayout에 ViewPager 설정
        tabLayout.removeAllTabs(); // ??

       /* for (int i=0; i < 4; i++){*/
//            tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(ICON_IDS[i])));
            Tabview_friend tabview_friend= new Tabview_friend(this);
            tabLayout.addTab(tabLayout.newTab().setCustomView(tabview_friend),0);
            Tabview_chatt tabview_chatt = new Tabview_chatt(this);
            tabLayout.addTab(tabLayout.newTab().setCustomView(tabview_chatt),1);
            Tabview_channel tabview_channel = new Tabview_channel(this);
            tabLayout.addTab(tabLayout.newTab().setCustomView(tabview_channel),2);
            Tabview_setting tabview_setting = new Tabview_setting(this);
            tabLayout.addTab(tabLayout.newTab().setCustomView(tabview_setting),3);

//        }
    }
}
