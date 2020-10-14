package com.demo.testapplication.drillShop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.demo.testapplication.R;

import java.util.ArrayList;

public class DrillActivity extends AppCompatActivity {

    private ArrayList <Drill> drills;
    private ListView listViewDrills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill);

        // hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        drills = new ArrayList<>();
        drills.add(new Drill(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol));
        drills.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.makita));
        drills.add(new Drill(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt));
        listViewDrills = findViewById(R.id.listViewDrills);
        // adapter to send data to listView
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);

        // listener of click on listview
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
                Drill drill = drills.get(position);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}