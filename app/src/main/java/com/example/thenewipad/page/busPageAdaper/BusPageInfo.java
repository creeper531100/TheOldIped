package com.example.thenewipad.page.busPageAdaper;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.BusStopRoute;
import com.example.thenewipad.function.JsonDataFormat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BusPageInfo extends AppCompatActivity {

    ViewPager viewPager;
    String[] contentArrary;
    TabLayout tabLayout;
    ArrayList<String> To = new ArrayList<>();
    ArrayList<String> Back = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_page_info);

        TextView titleText = findViewById(R.id.TitleText);
        TextView busHeaderText = findViewById(R.id.BusHeaderText);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "哈哈", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        String getContent = intent.getStringExtra("title");
        contentArrary = getContent.split("\n");
        String[] direction = contentArrary[1].split("-", 2);


        titleText.setText(contentArrary[0]);
        busHeaderText.setText(contentArrary[1]);

        JsonDataFormat<BusStopRoute> getJson = new JsonDataFormat<>
                ("https://ptx.transportdata.tw/MOTC/v2/Bus/StopOfRoute/City/Taichung/"
                        //RealTimeNearStop, StopOfRoute, Route
                        + contentArrary[0] + "?&$format=JSON", BusStopRoute.class);
        getJson.request();
        List<String> dataParsing = getJson.dataParsing();
        System.out.println(dataParsing);
        for (int i = 0; i< dataParsing.size() ; i+=3) {
            if(dataParsing.get(i + 1).equals(contentArrary[0])) {
                if(dataParsing.get(i).equals("1"))
                    To.add(dataParsing.get(i + 2));
                else
                    Back.add(dataParsing.get(i + 2));
            } //else
                //break;
        }

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), direction);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPagerAdapter);
    }

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
                    return new BusToPage(contentArrary[0], To);
                case 1:
                    return new BusBackPage(contentArrary[0], Back);
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