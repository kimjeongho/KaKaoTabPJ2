package com.example.kimjh.kakaotabpj;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    MyPagerAdapter mAdapter;

    static  final int[] ICON_IDS = {
            R.drawable.tab1,
            R.drawable.tab2,
            R.drawable.tab3,
            R.drawable.tab4
    };  // tabIcon Image...
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

        for (int i=0; i < 4; i++){
            tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(ICON_IDS[i])));
        }
    }
}
