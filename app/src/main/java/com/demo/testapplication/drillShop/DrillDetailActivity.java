package com.demo.testapplication.drillShop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.demo.testapplication.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewInterskolTitle;
    private TextView textViewInterskolInfo;
    private ImageView imageViewInterskolDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        // hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        textViewInterskolTitle = findViewById(R.id.textViewInterskolTitle);
        textViewInterskolInfo = findViewById(R.id.textViewInterskolInfo);
        imageViewInterskolDrill = findViewById(R.id.imageViewInterskolDrill);

        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title =intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            // set data to view
            textViewInterskolTitle.setText(title);
            textViewInterskolInfo.setText(info);
            imageViewInterskolDrill.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, DrillActivity.class);
            startActivity(backToCategory);
        }
    }
}