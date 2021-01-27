package com.example.thenewipad.page.mainAdaper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.BusRoute;
import com.example.thenewipad.function.JsonDataFormat;
import com.example.thenewipad.function.ProgramAdapter;

import java.util.ArrayList;


public class TransportationPage extends Fragment {
    private RequestQueue mQeue;
    private ListView lv;
    private EditText search;
    private Button searchBtn;
    private ArrayList<Integer> num = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.transportation_page, container, false);
        lv = (ListView) v.findViewById(R.id.buslist);
        mQeue = Volley.newRequestQueue(getActivity());
        busStop();
        return v; // a
    }


    public void busStop() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> dataParsing = new ArrayList<>();

        stringArrayList.add("12");
        stringArrayList.add("55");
        stringArrayList.add("700");
        stringArrayList.add("701");
        stringArrayList.add("900");
        stringArrayList.add("901");

        for (String s : stringArrayList) {
            JsonDataFormat<BusRoute> getJson = new JsonDataFormat<>(BusRoute.class);
            getJson.request("https://ptx.transportdata.tw/MOTC/v2/Bus/Route/City/Taichung/"+ s + "?&$format=JSON");
            dataParsing.add(getJson.dataParsingString(s));
        }
        for (int i = 0; i < dataParsing.size(); i++) {
            num.add(R.drawable.ic_baseline_search_24);
        }
        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), stringArrayList, num,
                        dataParsing, R.layout.default_list_page);
        lv.setAdapter(programAdapter);
    }
}
