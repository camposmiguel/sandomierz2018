package com.miguelcr.a01_duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextNickname = findViewById(R.id.editTextNick);
    }

    public void startGame(View view) {
        String name = editTextNickname.getText().toString();

        // Check if the name is empty
        if(name.isEmpty()) {
            Toast.makeText(this, "Please write a nickname", Toast.LENGTH_SHORT).show();
            editTextNickname.setError("Nickname is required");
        } else {
            // Start the game
            // Launch the GameActivity
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("nick", name);
            startActivity(i);
        }
    }
}
