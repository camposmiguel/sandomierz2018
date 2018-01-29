package com.miguelcr.a03_customlistview;

/**
 * Created by miguelcampos on 25/1/18.
 */

class RestaurantItem {
    // Define the properties
    String name;
    String description;
    int rate;
    boolean fav;
    String photo;
    float mediumPrice;

    // Generate > Constructor (select all the properties in the dialog)
    public RestaurantItem(String name, String description, int rate, boolean fav, String photo, float mediumPrice) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.fav = fav;
        this.photo = photo;
        this.mediumPrice = mediumPrice;
    }

    // Generate > Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(float mediumPrice) {
        this.mediumPrice = mediumPrice;
    }
}
