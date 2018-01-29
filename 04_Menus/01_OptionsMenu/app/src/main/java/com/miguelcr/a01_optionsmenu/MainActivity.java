package com.miguelcr.a01_optionsmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.actionTakePhoto:
                Toast.makeText(this, "Sorry, try to use a real app to take a photo!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionLogout:
                // We want to close the screen
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
