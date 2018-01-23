package com.averano.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.averano.tictactoe.R.drawable.circle;
import static com.averano.tictactoe.R.drawable.multiply;

public class JuegoActivity extends AppCompatActivity {

    ImageView tl, tc, tr, ml, mc, mr, bl, bc, br;
    Boolean turno = true;
    TextView player1, player2, turnoNombre;
    String p1, p2;
    int idCirculo, idCruz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Bundle extras = getIntent().getExtras();

        p1 = extras.getString(Constantes.EXTRA_PLAYER_1);
        p2 = extras.getString(Constantes.EXTRA_PLAYER_2);

        tl = findViewById(R.id.imageViewTL);
        tl.setTag(1);
        tc = findViewById(R.id.imageViewTC);
        tc.setTag(2);
        tr = findViewById(R.id.imageViewTR);
        tr.setTag(3);
        ml = findViewById(R.id.imageViewML);
        ml.setTag(4);
        mc = findViewById(R.id.imageViewMC);
        mc.setTag(5);
        mr = findViewById(R.id.imageViewMR);
        mr.setTag(6);
        bl = findViewById(R.id.imageViewBL);
        bl.setTag(7);
        bc = findViewById(R.id.imageViewBC);
        bc.setTag(8);
        br = findViewById(R.id.imageViewBR);
        br.setTag(9);

        player1 = findViewById(R.id.p1);
        player1.setText(p1);
        player2 = findViewById(R.id.p2);
        player2.setText(p2);
        turnoNombre = findViewById(R.id.NombreTurno);
        turnoNombre.setText(p1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.reset:
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void tap (View v){

        ImageView image = findViewById(v.getId());

        if (turno){
            image.setImageResource(circle);
            image.setTag(circle);
            idCirculo = (Integer)image.getTag();
            comprobarVictoria();
            turno = false;
            turnoNombre.setText(p2);
            image.setEnabled(false);

        }else{
            image.setImageResource(multiply);
            image.setTag(multiply);
            idCruz = (Integer)image.getTag();
            comprobarVictoria();
            turno = true;
            turnoNombre.setText(p1);
            image.setEnabled(false);
        }

    }

    public void comprobarVictoria(){
        if ((Integer)tl.getTag() == idCirculo && (Integer)tc.getTag() == idCirculo && (Integer)tr.getTag() == idCirculo ||
                (Integer)ml.getTag() == idCirculo && (Integer)mc.getTag() == idCirculo && (Integer)mr.getTag() == idCirculo ||
                (Integer)bl.getTag() == idCirculo && (Integer)bc.getTag() == idCirculo && (Integer)br.getTag() == idCirculo ||
                (Integer)tl.getTag() == idCirculo && (Integer)ml.getTag() == idCirculo && (Integer)bl.getTag() == idCirculo ||
                (Integer)tc.getTag() == idCirculo && (Integer)mc.getTag() == idCirculo && (Integer)bc.getTag() == idCirculo ||
                (Integer)tr.getTag() == idCirculo && (Integer)mr.getTag() == idCirculo && (Integer)br.getTag() == idCirculo ||
                (Integer)tl.getTag() == idCirculo && (Integer)mc.getTag() == idCirculo && (Integer)br.getTag() == idCirculo ||
                (Integer)tr.getTag() == idCirculo && (Integer)mc.getTag() == idCirculo && (Integer)bl.getTag() == idCirculo){
            Intent i = new Intent(this, WinActivity.class);
            i.putExtra(Constantes.EXTRA_WINNER, p1);
            i.putExtra(Constantes.EXTRA_LOSER, p2);
            startActivity(i);
        }else if ((Integer)tl.getTag() == idCruz && (Integer)tc.getTag() == idCruz && (Integer)tr.getTag() == idCruz ||
                (Integer)ml.getTag() == idCruz && (Integer)mc.getTag() == idCruz && (Integer)mr.getTag() == idCruz ||
                (Integer)bl.getTag() == idCruz && (Integer)bc.getTag() == idCruz && (Integer)br.getTag() == idCruz ||
                (Integer)tl.getTag() == idCruz && (Integer)ml.getTag() == idCruz && (Integer)bl.getTag() == idCruz ||
                (Integer)tc.getTag() == idCruz && (Integer)mc.getTag() == idCruz && (Integer)bc.getTag() == idCruz ||
                (Integer)tr.getTag() == idCruz && (Integer)mr.getTag() == idCruz && (Integer)br.getTag() == idCruz ||
                (Integer)tl.getTag() == idCruz && (Integer)mc.getTag() == idCruz && (Integer)br.getTag() == idCruz ||
                (Integer)tr.getTag() == idCruz && (Integer)mc.getTag() == idCruz && (Integer)bl.getTag() == idCruz){
            Intent i = new Intent(this, WinActivity.class);
            i.putExtra(Constantes.EXTRA_WINNER, p2);
            i.putExtra(Constantes.EXTRA_LOSER, p1);
            startActivity(i);
        }else if ((Integer)tl.getTag() != 1 && (Integer)tc.getTag() != 2 && (Integer)tr.getTag() != 3 &&
                (Integer)ml.getTag() != 4 && (Integer)mc.getTag() != 5 && (Integer)mr.getTag() != 6 &&
                (Integer)bl.getTag() != 7 && (Integer)bc.getTag() != 8 && (Integer)br.getTag() != 9){
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            recreate();
        }
    }
}
