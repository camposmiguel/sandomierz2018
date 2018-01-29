package com.miguelcr.a02_loginintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textViewEmail = findViewById(R.id.textViewEmail);

        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");

        // Set the email text into the TextView
        textViewEmail.setText(email);
    }
}
