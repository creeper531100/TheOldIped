package com.example.thenewipad.page.busPageAdaper;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusPageInfo extends AppCompatActivity {

    ViewPager viewPager;
    String[] contentArrary;
    TabLayout tabLayout;
    String route;
    ArrayList<String> To = new ArrayList<>();
    ArrayList<String> Back = new ArrayList<>();
    ArrayList<String> che = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_page_info);
        //物件初始化
        TextView titleText = findViewById(R.id.TitleText);
        TextView busHeaderText = findViewById(R.id.BusHeaderText);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);
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
        JsonDataFormat<BusStopRoute> getJson = new JsonDataFormat<>
                ("https://ptx.transportdata.tw/MOTC/v2/Bus/StopOfRoute/City/Taichung/"
                        + route + "?&$format=JSON", BusStopRoute.class);
        getJson.request();
        Map<String, List<Object>> contentMap = getJson.dataParsingList(route);
        //製作路線表格
        for(Object row : contentMap.get("1" + route))
            To.add(row.toString());
        for(Object row : contentMap.get("0" + route))
            Back.add(row.toString());

        //取得公車目前位置，能動但是可讀性差，未來會做優化
        JsonDataFormat<BusArriveStop> getPositive = new JsonDataFormat<>
                ("https://ptx.transportdata.tw/MOTC/v2/Bus/RealTimeNearStop/City/Taichung/"
                        + route + "?&$format=JSON", BusArriveStop.class);
        getPositive.request();
        Map<Integer, String> arrayList = new HashMap<>();

        List<String> dataParsing = getPositive.dataParsing();
        for (int i = 0; i< dataParsing.size() ; i+=3) {
            if(dataParsing.get(i).equals("0" + route)){
                System.out.println(dataParsing.get(i + 1));
                arrayList.put(To.indexOf(dataParsing.get(i + 1)), dataParsing.get(i + 2));
            }
        }
        System.out.println(arrayList.toString());
        for (int i = 0; i < contentMap.get("0" + route).size(); i++) {
            if(arrayList.containsKey(i)){
                che.add(arrayList.get(i));
                System.out.println(i);
            }
            che.add("沒車");
        }
        System.out.println(che.toString());

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
                    return new BusToPage(route, To, che);
                case 1:
                    //同上
                    return new BusBackPage(route, Back);
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