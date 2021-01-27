package com.example.thenewipad.function;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thenewipad.R;
import com.example.thenewipad.page.mainAdaper.WeatherInfoPage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<Integer> images;
    ArrayList<String> programName;
    ArrayList<String> programDescription;
    Map<String, ArrayList<String>> getDict = new HashMap<>();
    int page;


    public ProgramAdapter(Context context, ArrayList<String> programName, ArrayList<Integer> images,
                          ArrayList<String> programDescription, int page, Map<String, ArrayList<String>> getDict) {
        super(context, page, R.id.textView, programName);
        this.context = context;
        this.images = images;
        this.programName = programName;
        this.page = page;
        this.programDescription = programDescription;
        this.getDict = getDict;
    }//AA志

    public ProgramAdapter(Context context, ArrayList<String> programName, ArrayList<Integer> images,
                          ArrayList<String> programDescription, int page) {
        super(context, page, R.id.textView, programName);
        this.context = context;
        this.images = images;
        this.programName = programName;
        this.page = page;
        this.programDescription = programDescription;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View singleItem = convertView;

        ProgramViewHolder holder = null;
        if (singleItem==null){
            LayoutInflater layoutInflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(page, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        } else {
            holder = (ProgramViewHolder) singleItem.getTag();
        }
        holder.itemImage.setImageResource(images.get(position));
        holder.programTitle.setText(programName.get(position));
        holder.programDescription.setText(programDescription.get(position));
        singleItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!getDict.isEmpty()) {
                    setClickListener(programName.get(position).split("\\s+")[0]);
                }
            }
        });
        return singleItem;
    }

    public void setClickListener(String clickListener){
        Intent inte = new Intent(getContext(), WeatherInfoPage.class);
        inte.putExtra("getDict",(Serializable) getDict);
        inte.putExtra("clickListener", clickListener);
        getContext().startActivity(inte);
    }
}

class ProgramViewHolder{
    ImageView itemImage;
    TextView programTitle;
    TextView programDescription;
    ProgramViewHolder(View v){
        itemImage =v.findViewById(R.id.imageView);
        programTitle = v.findViewById(R.id.textView);
        programDescription = v.findViewById(R.id.textView2);
    }
}
