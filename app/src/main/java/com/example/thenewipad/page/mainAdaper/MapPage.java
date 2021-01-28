package com.example.thenewipad.page.mainAdaper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.mapSearchResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapPage extends Fragment implements OnMapReadyCallback{
    GoogleMap mMap ;
    Double coordinate[] = { 25.06229771146565, 121.45665165612434,
            24.14797281214013, 120.67348740607574,
            22.63612290120027, 120.33561337987628,
            25.033928667125192, 121.56308799118433,
            24.994638135578185, 121.30033616386112,
            23.000157415399592, 120.22600520300502,
            24.05170169108946, 120.51589880702338,
            22.55274366167078, 120.54304465342642,
            23.70946803187533, 120.43102624982598,
            24.838660477075393, 121.01760432203545,
            24.563149499827723, 120.81855013750791,
            23.451848903772355, 120.25545454729823,
            23.96086894723741, 120.97161714622617,
            24.759139240653102, 121.75362972574136,
            24.813806243242787, 120.9675779008551,
            25.127641246919104, 121.73899147309704,
            23.98726086266802, 121.60125798764587,
            23.48008478674472, 120.44876558228951,
            22.76133014718911, 121.14376240207108,
            24.449332112015394, 118.37697226999406,
            23.566944109909834, 119.61357799110984,
            26.160302588286946, 119.95133231785832};
    String city[] = {"新北市","台中市","高雄市","台北市","桃園市","台南市","彰化縣","屏東縣","雲林縣","新竹縣","苗栗縣",
            "嘉義縣","南投縣","宜蘭縣","新竹市","基隆市","花蓮縣","嘉義市","台東縣","金門縣","澎湖縣","連江縣"};
    Map<String,  Integer> getSum = new HashMap<>();
    Map<String, ArrayList<Double>> getCity = new HashMap<>();

    private void jsonPare() {
        String url = "https://od.cdc.gov.tw/eic/Weekly_Confirmation_Age_County_Gender_19CoV.json";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, (String) null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                for(int i = 0 ; i < 43;i+=2){
                    ArrayList<Double> arr =  new ArrayList<>();
                    Double[] d ={coordinate[i],coordinate[i+1]};
                    arr.add(coordinate[i]);
                    arr.add(coordinate[i+1]);
                    getCity.put(city[i/2],arr);
                }
                System.out.println(getCity.toString());

                String getJsonFormatFile = response.toString();
                Type RailStationListType = new TypeToken<ArrayList<mapSearchResult>>() {}.getType();
                Gson gsonReceiver = new Gson();
                List<mapSearchResult> obj = gsonReceiver.fromJson(getJsonFormatFile, RailStationListType);

                for (mapSearchResult row: obj) {
                    getSum.put(row.get縣市(), 0);

                }
                for(String a: city){
                    getSum.put(a, 0);
                }
                for (mapSearchResult row: obj) {
                    int sum = Integer.parseInt(row.get確定病例數());
                    getSum.put(row.get縣市(), Integer.valueOf(getSum.get(row.get縣市()))+sum);
                }
                for(int i = 0; i < 43; i++) {
                    LatLng sunmoonlake = new LatLng(coordinate[i], coordinate[i+1]);
                    //你想要標記在哪一點的經緯度
                    mMap.addMarker(new MarkerOptions().position(sunmoonlake)
                            .title(city[i/2])
                            //點選標記點後會跳出資訊欄的標題
                            .snippet("確診人數" + getSum.get(city[i/2]))).showInfoWindow();
                    //點選標記點後會跳出資訊欄的詳細內容
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sunmoonlake, 7));
                    //14這個是你想要呈現的地圖的倍率，可以自己試試調整看看，數字越大地圖越大
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("錯誤" + error);
            }
        });
        requestQueue.add(request);
    }
    private RequestQueue requestQueue;
    static final LatLng AGRA = new LatLng(27.174356, 78.042183);

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            requestQueue = Volley.newRequestQueue(getActivity());
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
             mMap = googleMap;
            jsonPare();

        }
    };



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_maps, container, false);
        Button launch = (Button) v.findViewById(R.id.btn);
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uriString = String.format("geo:%f,%f", AGRA.latitude, AGRA.longitude);
                Uri intentUri = Uri.parse(uriString);
                Intent intent = new Intent(Intent.ACTION_VIEW, intentUri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {




    }
}