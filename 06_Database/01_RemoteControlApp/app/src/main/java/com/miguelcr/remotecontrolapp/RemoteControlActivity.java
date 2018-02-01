package com.miguelcr.remotecontrolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class RemoteControlActivity extends AppCompatActivity {
    ImageView imageViewOnOff;
    boolean turnOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_control);

        imageViewOnOff = findViewById(R.id.imageViewOnOff);
    }

    public void turnOnOff(View view) {
        if(turnOn) {
            imageViewOnOff.setImageResource(R.drawable.ic_button_off);
            turnOn = false;
        } else {
            imageViewOnOff.setImageResource(R.drawable.ic_button_on);
            turnOn = true;
        }

    }
}
