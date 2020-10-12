package com.demo.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateOrderActivity extends AppCompatActivity {

    private TextView textViewHello;
    private TextView textViewChoose;
    private CheckBox checkMilk;
    private CheckBox checkSugar;
    private CheckBox checkLemon;
    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private String drink;
    private String name;
    private String password;
    private StringBuilder builderAdditions; // build additions from checkbox

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        // read name and password from intent
        Intent intent = getIntent();
        if (intent.hasExtra("username") && intent.hasExtra("password")) {
            name = intent.getStringExtra("username");
            password = intent.getStringExtra("password");
        } else {
            name = getString(R.string.default_name);
            password = getString(R.string.default_password);
        }

        drink = getString(R.string.tea);
        textViewHello = findViewById(R.id.textViewHello);
        String hello = String.format(getString(R.string.hello_client), name);
        textViewHello.setText(hello);

        textViewChoose = findViewById(R.id.textViewChoose);
        String additions = String.format(getString(R.string.choose_in_drink), drink);
        textViewChoose.setText(additions);

        checkMilk = findViewById(R.id.checkMilk);
        checkSugar = findViewById(R.id.checkSugar);
        checkLemon = findViewById(R.id.checkLemon);

        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);

        builderAdditions = new StringBuilder();
    }

    public void changeDrink(View view) {
        // change type of view to type of radio
        RadioButton button = (RadioButton) view;
        int id = button.getId(); // get id button that was pressed

        // if tea in radio - string drink to tea, and change spinner
        if (id == R.id.radioTea) {
            drink = getString(R.string.tea);
            spinnerTea.setVisibility(View.VISIBLE);
            spinnerCoffee.setVisibility(View.INVISIBLE);
            checkLemon.setVisibility(View.VISIBLE);
        } else if (id == R.id.radioCoffee) {
            drink = getString(R.string.coffee);
            spinnerTea.setVisibility(View.INVISIBLE);
            spinnerCoffee.setVisibility(View.VISIBLE);
            checkLemon.setVisibility(View.INVISIBLE);
        }
        String additions = String.format(getString(R.string.choose_in_drink), drink);
        textViewChoose.setText(additions);
    }

    public void sendOrder(View view) {
        builderAdditions.setLength(0); // clear checkbox

        if (checkMilk.isChecked()) {
            builderAdditions.append(getString(R.string.milk)).append(" ");
        }
        if (checkSugar.isChecked()) {
            builderAdditions.append(getString(R.string.sugar)).append(" ");
        }
        if (checkLemon.isChecked() && drink.equals(getString(R.string.tea))) {
            builderAdditions.append(getString(R.string.lemon)).append(" ");
        }
        String optionsOfDrink = "";
        if (drink.equals(getString(R.string.tea))) {
            optionsOfDrink = spinnerTea.getSelectedItem().toString();
        } else {
            optionsOfDrink = spinnerCoffee.getSelectedItem().toString();
        }
        String order = String.format(getString(R.string.order), name, password, drink, optionsOfDrink);

        String additions;
        if (builderAdditions.length() > 0) {
            additions = getString(R.string.additions) + builderAdditions.toString();
        } else {
            additions = "";
        }
        String fullOrder = order + additions;
        Intent intent = new Intent(this, OrderDetailActivity.class);
        intent.putExtra("fullOrder", fullOrder);
        startActivity(intent);
    }
}