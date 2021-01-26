package com.example.thenewipad.page.mainAdaper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thenewipad.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class ClickListPage extends AppCompatActivity {

    Date date = new Date();
    TextView showTime;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> contentArray = new ArrayList<>();
        setContentView(R.layout.click_list_page);
        Intent intent = getIntent();
        HashMap<String, ArrayList<String>> hashMap
                = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("getDict");
        String clickListener = intent.getStringExtra("clickListener");
        contentArray = hashMap.get(clickListener);

        String weatherStatus = contentArray.get(0);
        String rainChance = contentArray.get(1);
        String lowTemp = contentArray.get(2);
        String apparentTemp = contentArray.get(3);
        String highTemp = contentArray.get(4);
        int averageTemp = (Integer.parseInt(lowTemp) + Integer.parseInt(highTemp)) / 2;


        TextView city = (TextView) findViewById(R.id.city_title);
        TextView weatherStatusText = (TextView) findViewById(R.id.weather_status);
        TextView weatherAllStatus = (TextView) findViewById(R.id.weather_all_status);
        TextView temper = (TextView) findViewById(R.id.temper);
        TextView timeSet = (TextView) findViewById(R.id.showTimeinWeather);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        String sdf = (new SimpleDateFormat("M月D日 EE HH:mm")).format(date);

        System.out.println(hashMap);

        timeSet.setText(sdf);
        city.setText(clickListener);
        weatherStatusText.setText(weatherStatus); // 天氣狀態
        temper.setText(averageTemp + "°C"); //設定溫度
        imageView.setImageResource(getWeatherIcon(weatherStatus));
        weatherAllStatus.setText(highTemp +"°C　\n" + lowTemp +"°C　\n" + weatherStatus + "\n" +
                apparentTemp + "　\n" + rainChance + "%　\n商可");

    }

    int getWeatherIcon(String status){
        if(status.contains("晴時") || status.contains("時晴") ){
            return R.drawable.tai_yang_yun;
        } else if(status.contains("雷")){
            return R.drawable.lei_yu;
        } else if(status.contains("雨")){
            return R.drawable.xia_yu;
        } else if(status.contains("晴")){
            return R.drawable.tai_yang;
        } else if(status.contains("霧")){
            return R.drawable.rain;
        } else if(status.contains("風")){
            return R.drawable.qiang_feng;
        }else if(status.contains("雲")){
            return R.drawable.cloud;
        }else
            return R.drawable.weathererror;
    }
}