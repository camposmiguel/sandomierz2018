package com.averano.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    String ganador, perdedor;
    TextView winner;
    Button again, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Bundle extras = getIntent().getExtras();
        winner = findViewById(R.id.textView3);
        ganador = extras.getString(Constantes.EXTRA_WINNER);
        perdedor = extras.getString(Constantes.EXTRA_LOSER);
        winner.setText(ganador);

        again = findViewById(R.id.volverAJugar);
        menu = findViewById(R.id.ButtonMenu);

    }

    public void reset(View v){
        Intent i = new Intent(this, NuevoJuego.class);
        startActivity(i);
    }
    public void again(View v){
        Intent i = new Intent(this, JuegoActivity.class);

        i.putExtra(Constantes.EXTRA_PLAYER_1, ganador);
        i.putExtra(Constantes.EXTRA_PLAYER_2, perdedor);

        startActivity(i);
    }

}
