package com.example.thenewipad.function;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.thenewipad.formatFolder.BusArriveStop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class GetPtxBusJson {
    String url;
    String response = "";
    public GetPtxBusJson(String url){
        this.url = url;
        this.response = response;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String request() {
        HttpURLConnection connection = null;
        String str;
        String APPID = "8af3b6907d5c443d90b6bd2f18361c15";
        String APPKey = "6f5mGu2y_kH-MaeZ2NKlS0_MDzI";
        String xdate = getServerTime();
        String SignDate = "x-date: " + xdate;
        String respond = "";
        String Signature = "";
        try {
            Signature = HMAC_SHA1.Signature(SignDate, APPKey);
        } catch (SignatureException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println("Signature :" + Signature);
        String sAuth = "hmac username=\"" + APPID + "\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\""
                + Signature + "\"";
        System.out.println(sAuth);
        try {
            URL url = new URL(this.url);
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                SslUtils.ignoreSsl();
            }
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", sAuth);
            connection.setRequestProperty("x-date", xdate);
            connection.setRequestProperty("Accept-Encoding", "gzip");
            connection.setDoInput(true);
            //connection.setDoOutput(true);
            respond = connection.getResponseCode() + " " + connection.getResponseMessage();

            BufferedReader in;

            // 判斷來源是否為gzip
            if ("gzip".equals(connection.getContentEncoding())) {
                InputStreamReader reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
                in = new BufferedReader(reader);
            } else {
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                in = new BufferedReader(reader);
            }
            // 返回的數據已經過解壓
            StringBuffer buffer = new StringBuffer();
            // 讀取回傳資料
            String line = "";
            while ((line = in.readLine()) != null) {
                response += (line + "\n");
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    // 取得當下UTC時間
    public static String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

}