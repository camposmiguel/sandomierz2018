package com.averano.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoJuego extends AppCompatActivity implements View.OnClickListener {
    EditText player1, player2;
    Button nuevoJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_nuevo_juego);
        player1 = findViewById(R.id.editText);
        player2 = findViewById(R.id.editText2);
        nuevoJuego = findViewById(R.id.button);

        nuevoJuego.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(TextUtils.isEmpty(player1.getText()) || TextUtils.isEmpty(player2.getText())){
            Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            String p1 = player1.getText().toString();
            String p2 = player2.getText().toString();

            Intent i = new Intent(this, JuegoActivity.class);

            i.putExtra(Constantes.EXTRA_PLAYER_1, p1);
            i.putExtra(Constantes.EXTRA_PLAYER_2, p2);

            startActivity(i);
        }
    }
}
