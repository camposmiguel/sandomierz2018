package com.miguelcr.remotecontrolapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by miguelcampos on 31/1/18.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
