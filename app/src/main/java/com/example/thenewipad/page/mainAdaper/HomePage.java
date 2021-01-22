package com.example.thenewipad.page.mainAdaper;

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
        @SuppressLint("SimpleDateFormat") String sdf = (new SimpleDateFormat("目前a, HH:mm")).format(date);
        showTime.setText("空頁面...\n"+sdf);
        return v;
    }
}