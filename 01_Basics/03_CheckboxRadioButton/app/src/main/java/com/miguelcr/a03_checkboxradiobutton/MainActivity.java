package com.miguelcr.a03_checkboxradiobutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the layout
        setContentView(R.layout.activity_main);

        // Connect the editTextUsername with the View component
        // that we've in the layout
        editTextUsername = findViewById(R.id.editTextName);
    }



    public void showMessage(View view) {
        CheckBox terms = (CheckBox) view;
        if(terms.isChecked()) {
            Toast.makeText(this, "Ok, thanks for your attention!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sorry, you must to accept the terms!", Toast.LENGTH_SHORT).show();
        }
    }

    public void doLogin(View view) {
        String name = editTextUsername.getText().toString();

        if(name.isEmpty()) {
            Toast.makeText(this, "Please write a name!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MainActivity.this,UserPrivateActivity.class);
            startActivity(intent);
        }
    }
}
