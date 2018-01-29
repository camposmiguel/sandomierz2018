package com.miguelcr.a03_customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 25/1/18.
 */

class RestaurantAdapter extends ArrayAdapter<RestaurantItem> {
    Context ctx;
    int template;
    List<RestaurantItem> restaurantItems;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<RestaurantItem> objects) {
        super(context, resource, objects);

        ctx = context;
        template = resource;
        restaurantItems = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template,parent,false);

        // 1. Get a reference for all the View components
        ImageView imageViewPhoto = v.findViewById(R.id.imageViewPhoto);
        TextView textViewName = v.findViewById(R.id.textViewName);
        TextView textViewDescription = v.findViewById(R.id.textViewDescription);
        ImageView imageViewFav = v.findViewById(R.id.imageViewFav);
        TextView textViewPrice = v.findViewById(R.id.textViewPrice);
        TextView textViewRate = v.findViewById(R.id.textViewRate);

        // 2. Get the current Restaurant information
        RestaurantItem current = restaurantItems.get(position);
        String photoAddress = current.getPhoto();
        String name = current.getName();
        String description = current.getDescription();
        boolean isFavourite = current.isFav();
        float price = current.getMediumPrice();
        int rate = current.getRate();

        // 3. Set the information into the View components
        textViewName.setText(name);
        textViewDescription.setText(description);
        textViewPrice.setText("€ "+price);
        textViewRate.setText(String.valueOf(rate)); // int to String

        if(isFavourite) {
            // Change the image that appear in the ImageViewFav
            imageViewFav.setImageResource(R.drawable.ic_star_on);
        }

        Picasso.with(ctx)
                .load(photoAddress)
                .resize(600,200)
                .centerCrop()
                .into(imageViewPhoto);

        return v;
    }
}
