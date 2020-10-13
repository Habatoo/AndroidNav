package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickEnter(View view) {
        Intent intent = new Intent(this, EnterActivity.class);
        startActivity(intent);
    }

    public void onClickFirst(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void onClickSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void onClickSpinner(View view) {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    public void newIntend(View view) {
        Intent intent = new Intent(this, CreateMessageActivity.class);
        startActivity(intent);
    }

    public void selectAndroidSend(View view) {
        Intent intent = new Intent(this, DiffMessageActivity.class);
        startActivity(intent);
    }

    public void startWatch(View view) {
        Intent intent = new Intent(this, WatchActivity.class);
        startActivity(intent);
    }

    public void addingStartWatch(View view) {
        Intent intent = new Intent(this, WatchActivityAddActivity.class);
        startActivity(intent);
    }

    public void startCafeProject(View view) {
        Intent intent = new Intent(this, CafeProjectActivity.class);
        startActivity(intent);
    }

    public void startShopProject(View view) {
        Intent intent = new Intent(this, ShopProjectActivity.class);
        startActivity(intent);
    }
}