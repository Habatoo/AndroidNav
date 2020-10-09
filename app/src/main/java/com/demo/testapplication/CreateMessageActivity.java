package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    private EditText editTextCreateMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        editTextCreateMessage = findViewById(R.id.editTextCreateMessage);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, ReceivedMessageActivity.class);

        String msg = editTextCreateMessage.getText().toString().trim(); // get text from edittext
        intent.putExtra("message", msg); // put text from edittext to intend,

        startActivity(intent); // intend start ReceivedMessageActivity
    }
}