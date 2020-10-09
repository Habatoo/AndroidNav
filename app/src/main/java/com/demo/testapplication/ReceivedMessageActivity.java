package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedMessageActivity extends AppCompatActivity {

    private TextView textViewReceivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_message);

        // take intend that start this activity
        Intent intent = getIntent();
        // take data send with intend, data take by key
        String msg = intent.getStringExtra("message");

        // make object textview
        textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage);
        // put text from intend to textview
        textViewReceivedMessage.setText(msg);

    }
}