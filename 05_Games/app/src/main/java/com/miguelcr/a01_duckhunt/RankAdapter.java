package com.miguelcr.a01_duckhunt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import io.realm.RealmResults;

/**
 * Created by miguelcampos on 30/1/18.
 */

class RankAdapter extends ArrayAdapter<RankItem> {
    Context ctx;
    int template;
    RealmResults<RankItem> rankItemList;

    public RankAdapter(@NonNull Context context, int resource, @NonNull RealmResults<RankItem> objects) {
        super(context, resource, objects);
        ctx = context;
        template = resource;
        rankItemList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template,parent,false);

        // Get view components reference
        TextView textViewPosition = v.findViewById(R.id.textViewPosition);
        TextView textViewNick = v.findViewById(R.id.textViewNick);
        TextView textViewPoints = v.findViewById(R.id.textViewPoints);

        // Get the current item info
        RankItem current = rankItemList.get(position);
        String nick = current.getNick();
        int points = current.getPoints();

        // Set the information into the View Components
        textViewPosition.setText(String.valueOf(position+1));
        textViewNick.setText(nick);
        textViewPoints.setText(String.valueOf(points));

        return v;
    }
}
