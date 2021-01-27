package com.example.thenewipad.page.busPageAdaper;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.thenewipad.R;
import com.example.thenewipad.function.ProgramAdapter;

import java.util.ArrayList;

public class BusBackPage extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final ArrayList<Integer> num = new ArrayList<>();

    private ListView lv;
    private final ArrayList<String> buslist;
    private final ArrayList<String> arrivePlantNumb;

    public BusBackPage(String str, ArrayList<String> buslist, ArrayList<String> arrivePlantNumb) {
        this.buslist = buslist;
        this.arrivePlantNumb = arrivePlantNumb;
    }


    public static BusBackPage newInstance(String param1, String param2) {
        BusBackPage fragment = new BusBackPage(null, null, null);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bus_back_page, container, false);
        lv = v.findViewById(R.id.buslist);
        RequestQueue mQeue = Volley.newRequestQueue(getActivity());
        lv.setNestedScrollingEnabled(true);
        busStop();
        return v;
    }


    public void busStop() {
        for (int i = 0; i < buslist.size(); i++) {
            num.add(R.drawable.bus);
        }
        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), buslist, num, arrivePlantNumb, R.layout.bus_list_page);
        lv.setAdapter(programAdapter);
    }
}