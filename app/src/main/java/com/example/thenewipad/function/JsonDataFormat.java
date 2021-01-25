package com.example.thenewipad.function;

import com.example.thenewipad.formatFolder.ArriveTime;
import com.example.thenewipad.formatFolder.BusArriveStop;
import com.example.thenewipad.formatFolder.BusStopRoute;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonDataFormat<T> extends GetPtxBusJson {
    Class<T> type;
    public JsonDataFormat(Class<T> type) {
        this.type = type;
    }

    public <t> List<t> getDataList() {
        Type typeOfT = TypeToken.getParameterized(List.class, type).getType();
        return new Gson().fromJson(response, typeOfT);
    }


    //取路線用...
    public Map<String, List<Object>> dataParsingList() {
        Type RailStationListType = new TypeToken<ArrayList<BusStopRoute>>() {}.getType();
        Gson gsonReceiver = new Gson();
        Map<String, List<Object>> contentMap = new HashMap<>();
        List<BusStopRoute> obj = gsonReceiver.fromJson(response, RailStationListType);
        for (BusStopRoute row : obj) {
            contentMap.put(row.getDirection() + row.getRouteName().getZh_tw(), Arrays.asList(row.getStops().toArray()));
        }
        return contentMap;
    }

    //取到站時間...
    public Map<String, String> getRouteTime() {
        Type RailStationListType = new TypeToken<ArrayList<ArriveTime>>() {}.getType();
        Gson gsonReceiver = new Gson();
        Map<String, String> contentMap = new HashMap<>();
        String str = "";
        List<ArriveTime> obj = gsonReceiver.fromJson(response, RailStationListType);
        for (ArriveTime row : obj) {
            if(row.getStopStatus() != 1) { //1.未發車
                if (row.getEstimateTime() < 130) //0.即將抵達
                    str = row.getPlateNumb();
                else
                    str = (row.getEstimateTime() / 60) + "分鐘";
            } else {
                try {
                    str = row.getNextBusTime().substring(11,16);
                } catch (Exception e) {
                    str = "未發車";
                }
            }
            contentMap.put(row.getDirection() + row.getRouteName().getZh_tw() + row.getStopName().getZh_tw() , str);
        }
        return contentMap;
    }

    //嚴格搜尋
    public String dataParsingString(String searchRoute) {
        Map<String, String> contentMap = new HashMap<>();
        String[] splitText;
        List<T> obj = getDataList();
        for (T data : obj) {
            splitText = data.toString().split(",");
            contentMap.put(splitText[0], splitText[1]);
        }
        return contentMap.get(searchRoute);
    }

    //寬鬆搜尋，用於顯示搜尋建議
    public List<String> dataParsing() {
        List<String> contentText = new ArrayList<>();
        List<T> obj = getDataList();
        for (T data : obj) {
            contentText.addAll(Arrays.asList(data.toString().split(",")));
        }
        return contentText;
    }
}
