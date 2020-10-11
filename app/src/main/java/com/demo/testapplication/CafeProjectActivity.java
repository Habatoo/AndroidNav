package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CafeProjectActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_project);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextUserPassword = findViewById(R.id.editTextUserPassword);
    }

    public void createOrder(View view) {
        String username = editTextUserName.getText().toString().trim();
        String password = editTextUserPassword.getText().toString().trim();

        if (!username.isEmpty() && !password.isEmpty()) {
            Intent intent = new Intent(this, CreateOrderActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show();
        }
    }
}