package com.demo.testapplication.drillShop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.demo.testapplication.R;
import com.demo.testapplication.drillShop.DrillActivity;

public class ShopProjectActivity extends AppCompatActivity {

    private ListView listViewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_project);

        // hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        listViewTools = findViewById(R.id.listViewTools);
        // add listener - find area of list that was click
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplicationContext(), "Позиция: " + position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), DrillActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}