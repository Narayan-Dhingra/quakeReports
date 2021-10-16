package com.example.quakereports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.quakereports.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

    }

    private void init() {

        ArrayList<String> earthQuakes = new ArrayList<String>();
        earthQuakes.add("San Francisco");
        earthQuakes.add("London");
        earthQuakes.add("Tokyo");
        earthQuakes.add("Mexico City");
        earthQuakes.add("Moscow");
        earthQuakes.add("Rio de Janeiro");
        earthQuakes.add("Paris");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, earthQuakes);

        binding.listView.setAdapter(adapter);

    }

}