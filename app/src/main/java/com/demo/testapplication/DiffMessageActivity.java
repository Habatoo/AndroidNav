package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DiffMessageActivity extends AppCompatActivity {

    private EditText editTextMessageToAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_message);
        editTextMessageToAndroid = findViewById(R.id.editTextMessageToAndroid);
    }

    public void sendMessageToAndroid(View view) {
        String msg = editTextMessageToAndroid.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);

        // select type of send
        Intent chosenIntent = Intent.createChooser(intent, getString(R.string.send_question));
        startActivity(chosenIntent);
    }
}