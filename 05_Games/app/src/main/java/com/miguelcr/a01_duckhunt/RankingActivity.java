package com.miguelcr.a01_duckhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RankingActivity extends AppCompatActivity {
    ListView lista;
    RealmResults<RankItem> rankItemList;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        lista = findViewById(R.id.listViewRanking);

        // 1. Get the default connection to the local Database
        realm = Realm.getDefaultInstance();

        // 2. Get the list of RankItem saved in the Database
        // MySQL: SELECT * FROM RankItem
        rankItemList = realm.where(RankItem.class).findAll();

        // Adapter
        RankAdapter adapter = new RankAdapter(
                this,
                R.layout.rank_list_item,
                rankItemList
        );

        lista.setAdapter(adapter);
    }
}
