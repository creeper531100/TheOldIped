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
import com.example.thenewipad.function.GetBusData;
import com.example.thenewipad.function.ProgramAdapter;

import java.util.ArrayList;
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
    public void busStop(String inputStr){
        ArrayList<String> contentText = new ArrayList<String>();
        ArrayList<String> title = new ArrayList<String>();
        GetBusData getJson = new GetBusData("https://ptx.transportdata.tw/MOTC/v2/Bus/StopOfRoute/City/Taichung/"+inputStr+"?&$format=JSON");
        getJson.request();
        for (int i = 0; i < getJson.getStopRoute().size(); i++) {
            num.add(R.drawable.ic_baseline_search_24);
        }
        for(Map.Entry<String, String> row : getJson.getStopRoute().entrySet()){
            contentText.add(row.getKey());
            title.add(row.getValue());
        }
        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), title, num, contentText);
        lv.setAdapter(programAdapter);
    }
}
