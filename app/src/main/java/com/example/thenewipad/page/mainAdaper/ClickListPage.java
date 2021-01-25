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
        TextView title = (TextView) findViewById(R.id.city_title);
        TextView weather_content = (TextView) findViewById(R.id.weather_content);
        TextView contentText = (TextView) findViewById(R.id.contentText);
        title.setText(clickListener);
        contentArray = hashMap.get(clickListener);
        weather_content.setText(contentArray.toString());
        //TEST
        StringBuilder con = new StringBuilder();
        for (String a: contentArray) {
            con.append(a).append("\n");
        }
        contentText.setText(con.toString());
    }
}