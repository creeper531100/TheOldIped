package com.example.thenewipad.function;

import com.example.thenewipad.formatFolder.BusArriveStop;
import com.example.thenewipad.formatFolder.BusStopRoute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class GetBusData extends GetJson {
    public GetBusData(String url) {
        super(url);
    }
    public Map<String, String> busArriveStop() {
        Map<String, String> contentText = new Hashtable<>();
        Type jsonFormats = new TypeToken<ArrayList<BusArriveStop>>() {
        }.getType(); // JsonFormat 是指定要傳入的 格式化class
        Gson gsonReceiver = new Gson();
        if (response != null) {
            List<BusArriveStop> obj = gsonReceiver.fromJson(response, jsonFormats);
            for (BusArriveStop data : obj) {
                contentText.put(data.getStopName().toString() ,String.valueOf(data));
            }
        } else {
            contentText.put("錯誤", "沒有網際網路");
        }
        return contentText;
    }
    public Map<String, String> getStopRoute() {
        Map<String, String> contentText = new Hashtable<>(); //建立新的字典，方便回傳雙值
        Type jsonFormats = new TypeToken<ArrayList<BusStopRoute>>() {}.getType();  //將JSON的內容轉換List為對象
        Gson gsonReceiver = new Gson(); // 建立新的Gson型態
        if (response != null) { //response是Json網頁擷取下來的string
            List<BusStopRoute> obj = gsonReceiver.fromJson(response, jsonFormats);
            //將指定傳入的class格式化
            for (BusStopRoute data : obj) { //分解陣列
                for(BusStopRoute.StopsDTO A : data.getStops())
                contentText.put(A.toString(),A.toString());
            }
        } else {
            contentText.put("錯誤", "沒有網際網路");
        }
        return contentText;
    }
}
