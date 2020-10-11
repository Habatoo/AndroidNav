package com.demo.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class WatchActivityAddActivity extends AppCompatActivity {

    private TextView textViewTimerAdd;
    private int seconds = 0;
    private  boolean isRunning = false;
    private boolean wasRunning = false;
    final String resetTime = "0:00:00";

//    @Override
//    protected void onStop() {
//        super.onStop();
//        wasRunning = isRunning;
//        isRunning = false;
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        isRunning = wasRunning;
//    }

    @Override
    protected void onResume() {
        // change start method
        super.onResume();
        isRunning = wasRunning;
    }

    @Override
    protected void onPause() {
        // change stop method
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_add);

        textViewTimerAdd = findViewById(R.id.textViewTimerAdd);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        startActivity();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
    }

    public void startActivity(View view) {
        isRunning = true;
    }

    public void stopActivity(View view) {
        isRunning = false;
    }

    public void resetActivity(View view) {
        isRunning = false;
        seconds = 0;
        textViewTimerAdd.setText(resetTime);
    }

    private void startActivity() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, sec);
                textViewTimerAdd.setText(time);

                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}