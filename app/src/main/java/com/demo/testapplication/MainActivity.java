package com.demo.testapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        listViewProjects = findViewById(R.id.listViewProjects);
        // add listener - find area of list that was click
        listViewProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent enter = new Intent(getApplicationContext(), EnterActivity.class);
                        startActivity(enter);
                        break;
                    case 1:
                        Intent first = new Intent(getApplicationContext(), FirstActivity.class);
                        startActivity(first);
                        break;
                    case 2:
                        Intent second = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(second);
                        break;
                    case 3:
                        Intent spinner = new Intent(getApplicationContext(), SpinnerActivity.class);
                        startActivity(spinner);
                        break;
                    case 4:
                        Intent messenger = new Intent(getApplicationContext(), CreateMessageActivity.class);
                        startActivity(messenger);
                        break;
                    case 5:
                        Intent messengerAndroid = new Intent(getApplicationContext(), DiffMessageActivity.class);
                        startActivity(messengerAndroid);
                        break;
                    case 6:
                        Intent watch = new Intent(getApplicationContext(), WatchActivity.class);
                        startActivity(watch);
                        break;
                    case 7:
                        Intent watchRotate = new Intent(getApplicationContext(), WatchActivityAddActivity.class);
                        startActivity(watchRotate);
                        break;
                    case 8:
                        Intent cafe = new Intent(getApplicationContext(), CafeProjectActivity.class);
                        startActivity(cafe);
                        break;
                    case 9:
                        Intent shop = new Intent(getApplicationContext(), ShopProjectActivity.class);
                        startActivity(shop);
                        break;
                }
            }
        });
    }
}