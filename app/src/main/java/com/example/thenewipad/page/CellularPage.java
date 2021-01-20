package com.example.thenewipad.page;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.BusArriveStop;
import com.example.thenewipad.formatFolder.BusRoute;
import com.example.thenewipad.formatFolder.BusStopRoute;
import com.example.thenewipad.function.JsonDataFormat;
import com.example.thenewipad.function.ProgramAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CellularPage extends Fragment {
    private RequestQueue mQeue;
    private ListView lv;
    private EditText search;
    private Button searchBtn;
    private ArrayList<Integer> num = new ArrayList<Integer>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cellular_page, container, false);
        lv = (ListView) v.findViewById(R.id.Buslist);
        search = (EditText) v.findViewById(R.id.searchBar);
        mQeue = Volley.newRequestQueue(getActivity());
        busStop("701");
        Button searchBtn = (Button) v.findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String inputStr = search.getText().toString();
                busStop(inputStr);
            }
        });
        return v;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void busStop(String inputStr) {
        ArrayList<String> contentText = new ArrayList<String>();
        ArrayList<String> title = new ArrayList<String>();
        Map<String, String>direction = new HashMap<>();
        direction.put("0", "去程");
        direction.put("1", "回程");
        JsonDataFormat<BusRoute> getJson = new JsonDataFormat<BusRoute>
                ("https://ptx.transportdata.tw/MOTC/v2/Bus/Route/City/Taichung/"
                        //RealTimeNearStop, StopOfRoute, Route
                        + inputStr + "?&$format=JSON", BusRoute.class);

        getJson.request();
        List<String> dataParsing = getJson.dataParsing();
        System.out.println(dataParsing);
        for (int i = 0; i < dataParsing.size(); i++) {
            num.add(R.drawable.ic_baseline_search_24);
        }
        for (int i = 0; i< dataParsing.size() ; i+=2) {
            title.add(dataParsing.get(i));
            contentText.add(dataParsing.get(i+1));
        }
        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), title, num, contentText);
        lv.setAdapter(programAdapter);
    }
}
