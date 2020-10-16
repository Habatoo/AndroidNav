package com.demo.testapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class TimeTableActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ListView listViewNumbers;

    private ArrayList<Integer> numbers; // array for show in listview

    private int max = 20; // max number of seekbar
    private  int min = 1; // min number of seekbar
    private int count = 10; // number of string to show in listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        // hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        seekBar = findViewById(R.id.seekBar);
        listViewNumbers = findViewById(R.id.listViewNumbers);
        numbers = new ArrayList<>();

        // set seekbar max numbers
        seekBar.setMax(max);

        // adapter to can put data from array to list view
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        // place adapter or listview
        listViewNumbers.setAdapter(arrayAdapter);

        // add listener for seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // clear data before start
                numbers.clear();
                // don`t need to show 0 in seekbar
                if (progress < min) {
                    seekBar.setProgress(min);
                }
                // for show seekbar change
                for (int i = min; i <= count; i++) {
                    numbers.add(seekBar.getProgress() * i); // use seekbar data
                }
                // notify adapter about changing seekbar
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // set start progress on seekbar
        seekBar.setProgress(10);
    }
}