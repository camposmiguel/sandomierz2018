package com.miguelcr.remotecontrolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    RealmResults<AirConditionerItem> airConditionerItemList;
    Realm realm;
    AirConditionerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewAirConditioners);

        // Init the realm connection
        realm = Realm.getDefaultInstance();

        // SELECT * FROM AirConditionersItem
        airConditionerItemList = realm.where(AirConditionerItem.class).findAll();

        // Create the Adapter
        adapter = new AirConditionerAdapter(
                this,
                R.layout.air_conditioner_list_item,
                airConditionerItemList
        );

        // Link the Adapter and the ListView
        lista.setAdapter(adapter);

        // Add the on item click event
        lista.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.air_conditioners_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.actionNewAir:
                showNewAirDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showNewAirDialog() {
        Intent i = new Intent(this, NewAirActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Update the list of Air Conditioners
        airConditionerItemList = realm.where(AirConditionerItem.class).findAll();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, RemoteControlActivity.class);
        startActivity(i);
    }
}
