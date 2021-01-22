package com.example.thenewipad.function;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    public List<String> dataParsing() {
        List<String> contentText = new ArrayList<String>();
        if (response != null) {
            List<T> obj = getDataList();
            for (T data : obj) {
                contentText.addAll(Arrays.asList(data.toString().split(",")));
            }
        }
        return contentText;
    }
}
