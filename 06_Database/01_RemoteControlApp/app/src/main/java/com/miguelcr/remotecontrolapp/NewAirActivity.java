package com.miguelcr.remotecontrolapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class NewAirActivity extends AppCompatActivity {
    EditText editTextName, editTextTurnOn, editTextTurnOff, editTextDecrease, editTextIncrease;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_air);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editTextName = findViewById(R.id.editTextName);
        editTextTurnOn = findViewById(R.id.editTextTurnOn);
        editTextTurnOff = findViewById(R.id.editTextTurnOff);
        editTextIncrease = findViewById(R.id.editTextIncrease);
        editTextDecrease = findViewById(R.id.editTextDecrease);

        // Init the database
        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAirConditioner();
            }
        });
    }

    private void saveAirConditioner() {
        final String name = editTextName.getText().toString();
        final String turnOn = editTextTurnOn.getText().toString();
        final String turnOff = editTextTurnOff.getText().toString();
        final String increase = editTextIncrease.getText().toString();
        final String decrease = editTextDecrease.getText().toString();

        if(name.isEmpty() || turnOn.isEmpty() || turnOff.isEmpty()) {
            Toast.makeText(this, "Complete at least Name, Turn On and Turn Off codes", Toast.LENGTH_SHORT).show();
        } else {
            // We can save in the database
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    AirConditionerItem newAC = new AirConditionerItem();
                    newAC.setName(name);
                    newAC.setTurnOnCode(turnOn);
                    newAC.setTurnOffCode(turnOff);
                    newAC.setIncreaseCode(increase);
                    newAC.setDecreaseCode(decrease);

                    realm.copyToRealm(newAC);

                    // Destroy the current Activity
                    finish();
                }
            });
        }
    }

}
