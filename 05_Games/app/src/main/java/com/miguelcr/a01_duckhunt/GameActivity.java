package com.miguelcr.a01_duckhunt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView textViewTimer, textViewNick, textViewDucks;
    ImageView imageViewDuck;
    int counter = 0;
    String nick;
    boolean gameOver = false;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get the nickname value
        Bundle extras = getIntent().getExtras();
        nick = extras.getString("nick");

        textViewTimer = findViewById(R.id.textViewTimer);
        textViewDucks = findViewById(R.id.textViewDucks);
        textViewNick = findViewById(R.id.textViewNick);
        imageViewDuck = findViewById(R.id.imageViewDuck);

        // Set the nickname
        textViewNick.setText(nick);

        startCountdown();
    }

    private void startCountdown() {
        // 1 min = 60 s = 60000 ms
        countDownTimer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewTimer.setText( millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                textViewTimer.setText("Game over!");
                gameOver = true;
            }
        }.start();

    }

    // When user clicks on duck
    public void duckClicked(View view) {
        if(gameOver) {
            Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show();
        } else {
            // Increase the duck counter
            counter++;
            textViewDucks.setText(String.valueOf(counter));

            // Get the screen width and height
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int screenHeight = displayMetrics.heightPixels;
            int screenWidth = displayMetrics.widthPixels;

            // Move the duck to another random position
            Random rand = new Random();
            int minX = 0;
            int minY = 0;
            int maxX = screenWidth - imageViewDuck.getWidth();
            int maxY = screenHeight - imageViewDuck.getHeight();
            int randomNumX = rand.nextInt((maxX - minX) + 1) + minX;
            int randomNumY = rand.nextInt((maxY - minY) + 1) + minY;

            imageViewDuck.setX(randomNumX);
            imageViewDuck.setY(randomNumY);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.actionRestart:
                restartGame();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void restartGame() {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Do you want to restart the game?")
                .setTitle("Restart Game");

        // 2.2. Add buttons to the dialog
        builder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                gameOver = false;
                counter = 0;
                textViewDucks.setText("0");
                countDownTimer.cancel();
                countDownTimer.start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("View Ranking", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i = new Intent(GameActivity.this, RankingActivity.class);
                startActivity(i);
                // User cancelled the dialog
                dialog.dismiss();
            }
        });


        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        // 4. show the dialog
        dialog.show();
    }
}
