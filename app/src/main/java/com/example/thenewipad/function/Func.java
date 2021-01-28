package com.example.thenewipad.function;

import android.annotation.SuppressLint;
import android.icu.util.Calendar;

import com.example.thenewipad.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Func {

    public int getWeatherIcon(String status){
        if(status.contains("晴時") || status.contains("時晴") ){
            return R.drawable.tai_yang_yun;
        } else if(status.contains("雷")){
            return R.drawable.lei_yu;
        } else if(status.contains("雨")){
            return R.drawable.xia_yu;
        } else if(status.contains("晴")){
            return R.drawable.tai_yang;
        } else if(status.contains("霧")){
            return R.drawable.rain;
        } else if(status.contains("風")){
            return R.drawable.qiang_feng;
        }else if(status.contains("雲") || status.contains("陰")){
            return R.drawable.cloud;
        }else
            return R.drawable.weathererror;
    }

    @SuppressLint("SimpleDateFormat")
    public String addDate(int getDate, Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, getDate);
        SimpleDateFormat format1 = new SimpleDateFormat("M月d日 EEEE");
        return format1.format(cal.getTime());
    }

}


