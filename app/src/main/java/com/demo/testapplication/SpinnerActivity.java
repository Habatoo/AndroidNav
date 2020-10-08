package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinnerColors; // spinner any names
    private TextView textViewDescriptionText; // textview any names


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinnerColors = findViewById(R.id.spinnerColors); // spinner any name - from id in xml
        textViewDescriptionText = findViewById(R.id.textViewDescriptionText);
    }

    public void showDescription(View view) {
        // find positions of selected in spinner colors
        int position = spinnerColors.getSelectedItemPosition();

        // get description by position
        String description = getDescriptionByPosition(position);

        // send text to textview
        textViewDescriptionText.setText(description);
    }

    public String getDescriptionByPosition(int position) {
        // make array with data of string xml
        String[] descriptions = getResources().getStringArray(R.array.colors_descriptions);
        return descriptions[position];
    }
}