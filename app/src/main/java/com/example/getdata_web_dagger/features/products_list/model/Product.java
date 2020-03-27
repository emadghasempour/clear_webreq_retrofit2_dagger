package com.example.getdata_web_dagger.features.products_list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product {
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("price")
    @Expose
    String price;
    @SerializedName("product_name")
    @Expose
    String name;
    @SerializedName("imageUrl")
    @Expose
    String imageUrl;
    @SerializedName("is_off")
    @Expose
    boolean is_off;
    @SerializedName("description")
    @Expose
    String description;

    public Product(int id, String price, String imageUrl, boolean is_off, String description) {
        this.id = id;
        this.price = price;
        this.imageUrl = imageUrl;
        this.is_off = is_off;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isIs_off() {
        return is_off;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
