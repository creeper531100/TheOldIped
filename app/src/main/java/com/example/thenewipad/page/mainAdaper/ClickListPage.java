package com.example.thenewipad.page.mainAdaper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.thenewipad.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ClickListPage extends AppCompatActivity {

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
        System.out.println(clickListener);
        TextView city = (TextView) findViewById(R.id.city_title);
        TextView weatherStatus = (TextView) findViewById(R.id.weather_status);
        TextView temper = (TextView) findViewById(R.id.temper);
        city.setText(clickListener);
        contentArray = hashMap.get(clickListener);
        weatherStatus.setText(contentArray.get(0)); // 天氣狀態
        String lowTemp = contentArray.get(2);
        String highTemp = contentArray.get(4);
        int averageTemp = (Integer.parseInt(lowTemp) + Integer.parseInt(highTemp)) / 2;
        temper.setText(averageTemp + "°C"); //設定溫度

    }
}