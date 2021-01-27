package com.example.thenewipad.page.mainAdaper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.weatherFormatt;
import com.example.thenewipad.function.ProgramAdapter;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;


public class ClickListPage extends AppCompatActivity {

    Date date = new Date();
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<Integer> icon = new ArrayList<>();

    TextView city;
    TextView weatherStatusText;
    TextView temper;
    TextView timeSet;
    TextView updataTime;
    TextView measuresText;
    ImageView imageView;

    RequestQueue mQeue;
    ArrayList<String> contentArray;
    String clickListener;
    String weatherStatus;
    String rainChance;
    String lowTemp;
    String apparentTemp;
    ListView labView;
    String highTemp;
    TextView weatherAllStatus;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQeue = Volley.newRequestQueue(this);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        setContentView(R.layout.click_list_page);
        Intent intent = getIntent();
        HashMap<String, ArrayList<String>> hashMap
                = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("getDict");
        clickListener = intent.getStringExtra("clickListener");
        contentArray = hashMap.get(clickListener);
        weatherStatus = contentArray.get(0);
        rainChance = contentArray.get(1);
        lowTemp = contentArray.get(2);
        apparentTemp = contentArray.get(3);
        highTemp = contentArray.get(4);
        jsonPare();

    }

    public void jsonPare() {
        String url = "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-D0047-091?Authorization=CWB-AA4F530E-BC88-47F9-8D50-BFAAB1B0233B&format=JSON";
        Map<String, Map<String, ArrayList<String>>> weatherElementDict = new HashMap<>();
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gsonReceiver = new Gson();
                weatherFormatt formatObj = gsonReceiver.fromJson(response, weatherFormatt.class);
                for (weatherFormatt.RecordsDTO.LocationsDTO getList : formatObj.getRecords().getLocations()){
                    for(weatherFormatt.RecordsDTO.LocationsDTO.LocationDTO getLocation : getList.getLocation()){
                        Map<String, ArrayList<String>> weatherElementDict2nd = new HashMap<>();
                        for(weatherFormatt.RecordsDTO.LocationsDTO.LocationDTO.WeatherElementDTO getElement : getLocation.getWeatherElement()) {
                            ArrayList<String> weatherElementList = new ArrayList<>();
                            for(weatherFormatt.RecordsDTO.LocationsDTO.LocationDTO.WeatherElementDTO.TimeDTO getTime : getElement.getTime()){
                                weatherElementList.add(getTime.getElementValue().get(0).getValue());
                                weatherElementDict2nd.put(getElement.getDescription(), weatherElementList);
                            }
                            weatherElementDict.put(getLocation.getLocationName(), weatherElementDict2nd);
                        }
                    }
                }
                setPage(weatherElementDict);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        mQeue.add(request);
    }

    public void setPage(Map<String, Map<String, ArrayList<String>>> data){
        final String[] measures = {"", ""};
        labView = findViewById(R.id.future_weather_list);
        city = (TextView) findViewById(R.id.city_title);
        weatherStatusText = (TextView) findViewById(R.id.weather_status);
        measuresText = (TextView) findViewById(R.id.measures);
        weatherAllStatus = (TextView) findViewById(R.id.weather_all_status);
        temper = (TextView) findViewById(R.id.temper);
        timeSet = (TextView) findViewById(R.id.showTimeinWeather);
        updataTime = (TextView) findViewById(R.id.updata_time);
        imageView = (ImageView) findViewById(R.id.imageView2);

        ImageView backGroundImage = (ImageView) findViewById(R.id.imageView1);
        @SuppressLint("SimpleDateFormat") String ante = (new SimpleDateFormat("a")).format(date);

        if(ante.equals("上午")) {
            backGroundImage.setImageResource(R.drawable.weather_background0);
        }else
            backGroundImage.setImageResource(R.drawable.weather_background);


        @SuppressLint("SimpleDateFormat") String sdf = (new SimpleDateFormat("M月D日 EE HH:mm")).format(date);
        @SuppressLint("SimpleDateFormat") String getNowDate = (new SimpleDateFormat("M月D日")).format(date);

        Map<String , String> nowWeather = new HashMap<>();


        Objects.requireNonNull(data.get(clickListener)).forEach(new BiConsumer<String, ArrayList<String>>() {
            @Override
            public void accept(String s, ArrayList<String> strings) {
                if (strings.get(0).length() < 8){
                    measures[0] += s + "\n";
                    measures[1] += strings.get(0) + "　\n";
                    nowWeather.put(s, strings.get(0));
                }
            }
        });


        for (int i = 0, j = 0; i < data.get(clickListener).get("天氣現象").size(); i+=2, j++) {
            list1.add(addDate(j));
            list2.add(data.get(clickListener).get("天氣現象").get(i) + "\n溫度: " + data.get(clickListener).get("最低溫度").get(i) + "°C ~ " + data.get(clickListener).get("最高溫度").get(i) + "°C");
            icon.add(getWeatherIcon(addDate(j) + "  " + data.get(clickListener).get("天氣現象").get(i)));
        }
        System.out.println(list1);


        ProgramAdapter programAdapter =
                new ProgramAdapter(this, list1, icon, list2, R.layout.list_page);
        labView.setAdapter(programAdapter);
        labView.setNestedScrollingEnabled(true);




        updataTime.setText("更新日期: " + getNowDate);
        timeSet.setText(sdf);
        city.setText(clickListener);
        measuresText.setText(measures[0]);
        weatherAllStatus.setText(measures[1]);

        weatherStatusText.setText(weatherStatus); // 天氣狀態
        temper.setText(nowWeather.get("平均溫度")+ "°C"); //設定溫度
        imageView.setImageResource(getWeatherIcon(weatherStatus));

    }

    int getWeatherIcon(String status){
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
    public String addDate(int getDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, getDate);
        SimpleDateFormat format1 = new SimpleDateFormat("M月d日 EEEE");
        return format1.format(cal.getTime());
    }
}