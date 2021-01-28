package com.example.thenewipad.WeatherPageAdaper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.thenewipad.R;
import com.example.thenewipad.function.ProgramAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FuatureWeatherPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FuatureWeatherPage extends Fragment {

    ArrayList<String> list1, list2;
    ArrayList<Integer> icon;
    ListView labView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FuatureWeatherPage(ArrayList<String>list1 , ArrayList<String> list2, ArrayList<Integer> icon) {
        // Required empty public constructor
        this.list1 = list1;
        this.list2 = list2;
        this.icon = icon;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FuatureWeatherPage.
     */
    // TODO: Rename and change types and number of parameters
    public static FuatureWeatherPage newInstance(String param1, String param2) {
        FuatureWeatherPage fragment = new FuatureWeatherPage(null, null, null);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fuature_weather_page, container, false);

        labView = v.findViewById(R.id.future_weather_list);

        System.out.println(list1);


        ProgramAdapter programAdapter =
                new ProgramAdapter(getContext(), list1, icon, list2, R.layout.default_list_page);
        labView.setAdapter(programAdapter);
        labView.setNestedScrollingEnabled(true);

        return v;
    }
}