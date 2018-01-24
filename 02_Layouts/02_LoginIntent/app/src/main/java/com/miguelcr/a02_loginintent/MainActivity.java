package com.miguelcr.a02_loginintent;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageViewLogotype;
    EditText editTextEmail, editTextPass;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTexPass);
        imageViewLogotype = findViewById(R.id.imageViewLogo);
        buttonLogin = findViewById(R.id.buttonLogin);

        Picasso.with(this)
                .load("https://brightcove04pmdo-a.akamaihd.net/3653334524001/3653334524001_5381043941001_5379748916001-vs.jpg")
                .into(imageViewLogotype);

        // Button login click
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Get the email and pass that the user wrote
        String email = editTextEmail.getText().toString();
        String pass = editTextPass.getText().toString();

        if(email.equals("luke@lightside.com") && pass.equals("theforce")) {
            Intent i = new Intent(this, UserActivity.class);
            startActivity(i);
        } else {
            editTextEmail.setError("The email is incorrect!");
        }
    }
}
