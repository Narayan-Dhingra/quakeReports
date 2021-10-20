package com.example.quakereports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.quakereports.Modal.EarthQuake;
import com.example.quakereports.adapter.EarthQuakeAdapter;
import com.example.quakereports.databinding.ActivityMainBinding;
import com.example.quakereports.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

        Log.d("narayan", "onCreate: " + Utils.extractEarthquakes());

    }

    private void init() {


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(new EarthQuakeAdapter(Utils.extractEarthquakes(), this));



    }

}