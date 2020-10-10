package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class WatchActivity extends AppCompatActivity {

    int seconds = 0; // numbers of seconds from start
    boolean isRunning = false; // if watch running
    private TextView textViewTimer;
    final String resetTime = "0:00:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        textViewTimer = findViewById(R.id.textViewTimer);
        runTimer();
    }

    public void startWatch(View view) {
        isRunning = true;
    }

    public void stopWatch(View view) {
        isRunning = false;
    }

    public void resetWatch(View view) {
        isRunning = false;
        seconds = 0;
        textViewTimer.setText(resetTime);
    }

    private void runTimer() {
        // add handler - from it can start method that change data in interface
        final Handler handler = new Handler();
        // start runnable immediately
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, sec);
                textViewTimer.setText(time);

                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000); // run method another
            }
        });


    }
}