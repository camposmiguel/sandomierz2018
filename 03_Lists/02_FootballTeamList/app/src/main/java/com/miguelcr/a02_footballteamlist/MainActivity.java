package com.miguelcr.a02_footballteamlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> footballTeamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get a reference to the ListView component
        lista = findViewById(R.id.listViewFootballTeams);

        // 2. list of Football teams > initialize > add student names
        footballTeamList = new ArrayList<>();
        footballTeamList.add("1. Real Madrid FC");
        footballTeamList.add("...");
        footballTeamList.add("1000. Barcelona");

        // 3. Create the adapter
        ArrayAdapter studentAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                footballTeamList
        );

        // 4. Connect the adapter with the ListView component
        lista.setAdapter(studentAdapter);

        // 5. Declare a click event
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(
                this,
                "Football Team: "+footballTeamList.get(position),
                Toast.LENGTH_SHORT
        ).show();

        // Declare that we want to show a new Screen
        Intent christinaIntent = new Intent(
                MainActivity.this,
                DetailTeamActivity.class);

        // Include extra infor in the Intent
        // teamName = Valencia;
        // position = 1;
        christinaIntent.putExtra("teamName",footballTeamList.get(position));
        christinaIntent.putExtra("position",position);

        // Launch de DetailTeamActivity
        startActivity(christinaIntent);
    }
}
