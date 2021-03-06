package com.example.thenewipad.page.mainAdaper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.weatherFormat;
import com.example.thenewipad.function.Func;
import com.example.thenewipad.function.ProgramAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class WeatherMainPage extends Fragment {
    private ArrayList<String> itemList = new ArrayList<String>();
    private ArrayList<String> itemList2 = new ArrayList<String>();
    private RequestQueue mQeue;
    private ArrayList<Integer> num = new ArrayList<Integer>();
    private ListView lv;
    Func getWeatherIcon = new Func();
    /*
     *  @NonNull        傳入的值不能為空
     *  @Nullable       傳入的值可以為空
     *  LayoutInflater  載入布局(layout)，並生成View
     *  inflate         將xml定義的布局(layout)文件查找出来
     *  ViewGroup       進行建構
     *  findViewById    找出元件ID(Button, EditText之類的)
     *  Bundle          文件串接
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.weather_main_page, container, false);
        //聲明 BusText
        lv = (ListView) v.findViewById(R.id.weather_list);
        lv.setNestedScrollingEnabled(true);
        mQeue = Volley.newRequestQueue(getActivity());
        jsonPare();
        return v;
    }
    private void jsonPare() {
        String url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-AA4F530E-BC88-47F9-8D50-BFAAB1B0233B&format=JSON";

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Map<String, ArrayList<String>> weatherElementDict = new HashMap<>();
                Gson gsonReceiver = new Gson();
                weatherFormat formatObj = gsonReceiver.fromJson(response, weatherFormat.class);
                for (weatherFormat.RecordsDTO.LocationDTO getLoaction : formatObj.getRecords().getLocation()){
                    ArrayList<String> weatherElementList = new ArrayList<>();
                    for(weatherFormat.RecordsDTO.LocationDTO.WeatherElementDTO getWeatherElement
                            : getLoaction.getWeatherElement()){
                        weatherElementList.add(getWeatherElement.getTime().get(0).getParameter().getParameterName());
                    }
                    weatherElementDict.put(getLoaction.getLocationName(), weatherElementList);
                }


                weatherElementDict.forEach(new BiConsumer<String, ArrayList<String>>() {
                    @Override
                    public void accept(String s, ArrayList<String> strings) {
                        itemList.add(s + "  " + strings.get(0));
                        itemList2.add(strings.get(3) + ", 降雨機率" + strings.get(1) + "%\n"
                                + "氣溫: " + strings.get(2) + "度 ~ " + strings.get(4) + "度");
                        num.add(getWeatherIcon.getWeatherIcon(strings.get(0)));
                    }
                });
                ProgramAdapter programAdapter = new ProgramAdapter(getContext(),itemList , num, itemList2 ,
                        R.layout.default_list_page, weatherElementDict);
                lv.setAdapter(programAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        mQeue.add(request);
    }
}