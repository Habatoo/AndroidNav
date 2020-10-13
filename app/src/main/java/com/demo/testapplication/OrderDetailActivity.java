package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {

    private TextView textViewReceivedOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        textViewReceivedOrder = findViewById(R.id.textViewReceivedOrder);

        Intent intent = getIntent();
        if (intent.hasExtra("fullOrder")) {
            String fullOrder = intent.getStringExtra("fullOrder");
            textViewReceivedOrder.setText(fullOrder);
        } else {
            Intent backToLogin = new Intent(this, CafeProjectActivity.class);
            startActivity(backToLogin);
        }
    }
}