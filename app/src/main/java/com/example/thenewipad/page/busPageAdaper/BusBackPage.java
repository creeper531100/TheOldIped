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
    private ArrayList<Integer> num = new ArrayList<>();
    private RequestQueue mQeue;

    private String mParam1;
    private String mParam2;
    private String str;
    private ListView lv;
    private ArrayList<String> buslist;

    public BusBackPage(String str, ArrayList<String> buslist) {
        this.str = str;
        this.buslist = buslist;
    }


    public static BusBackPage newInstance(String param1, String param2) {
        BusBackPage fragment = new BusBackPage(null, null);
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bus_back_page, container, false);
        lv = (ListView) v.findViewById(R.id.buslist);
        mQeue = Volley.newRequestQueue(getActivity());
        lv.setNestedScrollingEnabled(true);
        busStop();
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void busStop() {
        for (int i = 0; i < buslist.size(); i++) {
            num.add(R.drawable.bus);
        }
        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), buslist, num, buslist, R.layout.list_page);
        lv.setAdapter(programAdapter);
    }
}