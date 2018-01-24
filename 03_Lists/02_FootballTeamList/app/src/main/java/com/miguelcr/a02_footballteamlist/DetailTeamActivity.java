package com.miguelcr.a02_footballteamlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailTeamActivity extends AppCompatActivity {
    TextView textViewTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        textViewTeam = findViewById(R.id.textViewTeamName);

        // get the extra info that we receive in the Intent object
        // The complete set of extras
        Bundle extras = getIntent().getExtras();

        String name = extras.getString("teamName");
        int position = extras.getInt("position");

        textViewTeam.setText(name);
    }
}
