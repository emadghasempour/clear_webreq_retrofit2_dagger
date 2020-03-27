package com.example.getdata_web_dagger.features.products_list.datasource;

import com.example.getdata_web_dagger.features.products_list.model.Product;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ProductsApi {
    @GET("products_list.json")
    Flowable<List<Product>> getUser();
}
