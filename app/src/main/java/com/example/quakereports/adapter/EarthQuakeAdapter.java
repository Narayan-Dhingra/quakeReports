package com.example.quakereports.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quakereports.MainActivity;
import com.example.quakereports.Modal.EarthQuake;
import com.example.quakereports.R;
import com.example.quakereports.utils.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EarthQuakeAdapter extends RecyclerView.Adapter<EarthQuakeAdapter.MyViewHolder> {

    List<EarthQuake> earthQuakeList;
    Context context;
    public static final String LOCATION_SEPERATOR = ", ";

    public EarthQuakeAdapter(List<EarthQuake> arrayList, Context context) {
        this.earthQuakeList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.earth_quake_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NumberFormat nm = NumberFormat.getNumberInstance();
        EarthQuake list = earthQuakeList.get(position);
        DecimalFormat formatter = new DecimalFormat("0.0");
        holder.magnitude.setText(formatter.format(list.getMagnitude()));
        Map<String,String> locationMap = splitLocationName(list.getCityName());
        holder.locationOffSet.setText(locationMap.get("location offset"));
        holder.primaryLocation.setText(locationMap.get("primary location"));

        Map<String,String> timeAndDateMap = Utils.convertUnixTime(list.getTime());

        holder.date.setText(timeAndDateMap.get("date"));
        holder.time.setText(timeAndDateMap.get("time"));

        Log.d("monu", "date " +timeAndDateMap.get("date"));
        Log.d("monu", "time " +timeAndDateMap.get("time"));


        GradientDrawable magnitudeCircle = (GradientDrawable) holder.magnitude.getBackground();

        int magnitudeColor = getMagnitudeColor(list.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);

//        holder.layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openWebPage(list.getUrl());
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return earthQuakeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView magnitude, locationOffSet, primaryLocation, date, time;
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            magnitude = (TextView) itemView.findViewById(R.id.magnitude);
            locationOffSet = (TextView) itemView.findViewById(R.id.location_offset);
            primaryLocation = (TextView) itemView.findViewById(R.id.primary_Location);
            date = (TextView) itemView.findViewById(R.id.dateOfQuake);
            time = (TextView) itemView.findViewById(R.id.time);
            layout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);


        }
    }

    public HashMap<String, String> splitLocationName(String location) {

        HashMap<String, String> locationMap = new HashMap<>();
        String[] locationArray;

        if (location.contains(",")){

            locationArray = location.split(LOCATION_SEPERATOR);

            locationMap.put("location offset", locationArray[0]);
            locationMap.put("primary location", locationArray[1]);

        }
        else {
            locationMap.put("location offset", "near by");
            locationMap.put("primary location", location);
        }

        return locationMap;
    }

    public final void  openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    static URL URLofString(String s){
        URL r=null;
        try {
            r= new URL(s);
        } catch (MalformedURLException e) { throw new RuntimeException(e); }
        return r;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(context, magnitudeColorResourceId);
    }

}
