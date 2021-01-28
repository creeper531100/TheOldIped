package com.example.thenewipad.page.busPageAdaper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.BusArriveStop;
import com.example.thenewipad.formatFolder.BusStopRoute;
import com.example.thenewipad.function.JsonDataFormat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BusInfoPage extends AppCompatActivity {

    ViewPager viewPager;
    String[] contentArrary;
    TabLayout tabLayout;
    String route;

    ArrayList<String> To = new ArrayList<>();
    ArrayList<String> Back = new ArrayList<>();
    ArrayList<String> toArriveStop = new ArrayList<>();
    ArrayList<String> backArriveStop = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_info_page);
        //物件初始化
        TextView titleText = findViewById(R.id.TitleText);
        TextView busHeaderText = findViewById(R.id.BusHeaderText);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager2);
        //加入我的最愛
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "哈哈", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //取得搜尋資訊
        Intent intent = getIntent();
        String getContent = intent.getStringExtra("title");//取得搜尋框文字
        //將換行符號分割
        contentArrary = getContent.split("\n");
        //0: 路線, 1: 路線簡介[例如: 701(0) 豐原東站-新建國市場(1)]
        route = contentArrary[0].toUpperCase();
        String routeContent = contentArrary[1];
        //分割來回方向[例如: 豐原東站(1) - 新建國市場(1)]
        String[] direction = routeContent.split("-", 2);
        //標題文字設定
        titleText.setText(route);
        busHeaderText.setText(routeContent);

        //取得路線資訊
        JsonDataFormat<BusStopRoute> getRouteStop = new JsonDataFormat<> (BusStopRoute.class);
        getRouteStop.request("https://ptx.transportdata.tw/MOTC/v2/Bus/StopOfRoute/City/Taichung/"+
                route + "?&$format=JSON");
        Map<String, List<Object>> contentMap = getRouteStop.dataParsingList();


        //取得預估時間
        JsonDataFormat<BusArriveStop> getEstimatedTimeOfArrival= new JsonDataFormat<> (BusArriveStop.class);
        getEstimatedTimeOfArrival.request("https://ptx.transportdata.tw/MOTC/v2/Bus/EstimatedTimeOfArrival/City/Taichung/"+
                route + "?&$format=JSON");
        Map<String, String> arriveTime = getEstimatedTimeOfArrival.getRouteTime();


        String toSearchKey = "1" + route;
        String backSearchKey = "0" + route;

        //製作路線表格
        for(Object row : Objects.requireNonNull(contentMap.get(toSearchKey))) {
            To.add(row.toString());
            toArriveStop.add(arriveTime.get(toSearchKey + row.toString()));
        }

        for(Object row : Objects.requireNonNull(contentMap.get(backSearchKey))) {
            Back.add(row.toString());
            backArriveStop.add(arriveTime.get(backSearchKey + row.toString()));
        }

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), direction);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPagerAdapter);
    }

    //製作分頁用
    class MyPagerAdapter extends FragmentPagerAdapter{
        String[] fragmentNames;
        public MyPagerAdapter(@NonNull FragmentManager fm, String[] fragmentNames) {
            super(fm);
            this.fragmentNames = fragmentNames;
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    //將父業的資料給子頁
                    return new BusToPage(route, To, toArriveStop);
                case 1:
                    //同上
                    return new BusBackPage(route, Back, backArriveStop);
            }
            return null;
        }
        @Override
        public int getCount() {
            return fragmentNames.length;
        }
        public CharSequence getPageTitle(int position){
            return fragmentNames[position];
        }
    }
}