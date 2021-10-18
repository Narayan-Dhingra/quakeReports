package com.example.quakereports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quakereports.Modal.EarthQuake;
import com.example.quakereports.R;
import com.example.quakereports.utils.Utils;

import java.text.NumberFormat;
import java.util.List;

public class EarthQuakeAdapter extends RecyclerView.Adapter<EarthQuakeAdapter.MyViewHolder> {

    List<EarthQuake> earthQuakeList;
    Context context;

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
        holder.magnitude.setText( nm.format(list.getMagnitude()));
        holder.cityName.setText(list.getCityName());
//        holder.date.setText(nm.format(list.getTime()));
        holder.date.setText(Utils.convertUnixTimeToFormattedDate(list.getTime()));

    }

    @Override
    public int getItemCount() {
        return earthQuakeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView magnitude, cityName, date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            magnitude = (TextView) itemView.findViewById(R.id.magnitude);
            cityName = (TextView) itemView.findViewById(R.id.cityName);
            date = (TextView) itemView.findViewById(R.id.date);

        }
    }

}
