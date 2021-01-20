package com.example.thenewipad.page;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thenewipad.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class HomePage extends Fragment {

    Date date = new Date();
    TextView showTime;
    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page, container, false);
        showTime = (TextView) v.findViewById(R.id.TitleText);
        //time
        @SuppressLint("SimpleDateFormat") String ante = (new SimpleDateFormat("a")).format(date);
        @SuppressLint("SimpleDateFormat") String sdf = (new SimpleDateFormat("現在是HH:mm")).format(date);
        if (ante.equals("上午"))
            showTime.setText("早安\n"+sdf);
        else
            showTime.setText("晚安\n"+sdf);
        return v;
    }
}