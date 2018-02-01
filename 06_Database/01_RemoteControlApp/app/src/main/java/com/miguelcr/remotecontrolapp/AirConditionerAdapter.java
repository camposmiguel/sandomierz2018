package com.miguelcr.remotecontrolapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by miguelcampos on 31/1/18.
 */

class AirConditionerAdapter extends ArrayAdapter<AirConditionerItem> {
    Context ctx;
    int template;
    RealmResults<AirConditionerItem> realmResults;


    public AirConditionerAdapter(@NonNull Context context, int resource, @NonNull RealmResults<AirConditionerItem> objects) {
        super(context, resource, objects);
        ctx = context;
        template = resource;
        realmResults = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template,parent,false);

        AirConditionerItem current = realmResults.get(position);

        TextView textViewName = v.findViewById(R.id.textViewName);

        textViewName.setText(current.getName());

        return v;
    }


}
