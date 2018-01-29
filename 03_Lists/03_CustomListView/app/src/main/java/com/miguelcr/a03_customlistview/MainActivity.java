package com.miguelcr.a03_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<RestaurantItem> restaurantItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewRestaurants);

        restaurantItemList = new ArrayList<>();
        restaurantItemList.add(new RestaurantItem(
                "Goiko Grill",
                "The best NYC hamburguer in Seville",
                5,
                true,
                "https://www.goikogrill.com/wp-content/uploads/2017/01/GOIKO_GRILL_WEB-3.jpg",
                20.0f
                ));
        restaurantItemList.add(new RestaurantItem(
                "La Tagliatella",
                "Italian food: pizzas & pasta",
                4,
                false,
                "https://media-cdn.tripadvisor.com/media/photo-s/03/4d/e2/76/la-tagliatella.jpg",
                15.5f
        ));
        restaurantItemList.add(new RestaurantItem(
                "McDonalds",
                "Fast food restaurant",
                1,
                false,
                "https://media-cdn.tripadvisor.com/media/photo-o/04/51/2a/54/mcdonald-s.jpg",
                2.0f
        ));

        // Custom Adapter for the Restaurants list.
        RestaurantAdapter adapter = new RestaurantAdapter(
                this,
                R.layout.restaurant_list_item,
                restaurantItemList
        );

        lista.setAdapter(adapter);
    }
}
