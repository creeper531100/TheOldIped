package com.example.thenewipad.page.busPageAdaper;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.formatFolder.BusRoute;
import com.example.thenewipad.formatFolder.BusStopRoute;
import com.example.thenewipad.function.JsonDataFormat;
import com.example.thenewipad.function.ProgramAdapter;

import java.util.ArrayList;
import java.util.List;

public class BusToPage extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final ArrayList<Integer> num = new ArrayList<>();

    private ListView lv; //表格初始化
    private final ArrayList<String> buslist;

    //傳入父業的資料給子頁
    ArrayList<String> arrivePlantNumb;
    public BusToPage(String str, ArrayList<String> buslist, ArrayList<String> arrivePlantNumb) {
        this.buslist = buslist;
        this.arrivePlantNumb = arrivePlantNumb;
    }
    //這裡不用管，我也看不懂
    public static BusToPage newInstance(String param1, String param2) {
        BusToPage fragment = new BusToPage(null, null, null);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    //一樣看不懂:P
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //分頁初始化
        View v = inflater.inflate(R.layout.fragment_bus_to_page, container, false);
        lv = v.findViewById(R.id.buslist);
        RequestQueue mQeue = Volley.newRequestQueue(getActivity());
        lv.setNestedScrollingEnabled(true);//滑動效果
        busStop();
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void busStop() {
        for (int i = 0; i < buslist.size(); i++) {
            num.add(R.drawable.bus);
        }
        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), buslist, num, arrivePlantNumb, R.layout.bus_list_page);
        lv.setAdapter(programAdapter);
    }
}