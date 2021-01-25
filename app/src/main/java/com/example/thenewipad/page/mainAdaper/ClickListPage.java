package com.example.thenewipad.page.mainAdaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.thenewipad.R;

import java.util.ArrayList;

public class ClickListPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_list_page);
        Intent intent = getIntent();
        System.out.println(intent.getStringArrayListExtra("getList"));

    }
}