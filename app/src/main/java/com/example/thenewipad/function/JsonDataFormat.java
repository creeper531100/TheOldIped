package com.example.thenewipad.function;

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
    public JsonDataFormat(String url, Class<T> type) {
        super(url);
        this.type = type;
    }

    public <t> List<t> getDataList() {
        Type typeOfT = TypeToken.getParameterized(List.class, type).getType();
        return new Gson().fromJson(response, typeOfT);
    }


    //取路線用，因為分析資料比較雜，所以分開來寫
    public Map<String, List<Object>> dataParsingList(String searchRoute) {
        Type RailStationListType = new TypeToken<ArrayList<BusStopRoute>>() {}.getType();
        Gson gsonReceiver = new Gson();
        Map<String, List<Object>> contentMap = new HashMap<>();
        List<BusStopRoute> obj = gsonReceiver.fromJson(response, RailStationListType);
        for (BusStopRoute row : obj) {
            contentMap.put(row.getDirection() + row.getRouteName().getZh_tw(), Arrays.asList(row.getStops().toArray()));
        }
        return contentMap;
    }

    //嚴格搜尋
    public String dataParsingString(String searchRoute) {
        Map<String, String> contentMap = new HashMap<>();
        String[] splitText;
        if (response != null) {
            List<T> obj = getDataList();
            for (T data : obj) {
                splitText = data.toString().split(",");
                contentMap.put(splitText[0], splitText[1]);
            }
        }
        return contentMap.get(searchRoute);
    }

    //寬鬆搜尋，用於顯示搜尋建議
    public List<String> dataParsing() {
        List<String> contentText = new ArrayList<>();
        if (response != null) {
            List<T> obj = getDataList();
            for (T data : obj) {
                contentText.addAll(Arrays.asList(data.toString().split(",")));
            }
        }
        return contentText;
    }
}
