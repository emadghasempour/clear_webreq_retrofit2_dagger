package com.example.getdata_web_dagger.features.products_list.datasource;

import com.example.getdata_web_dagger.features.products_list.model.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class NetworkDataSource {

    ProductsApi productsApi;

    @Inject
    public NetworkDataSource(ProductsApi productsApi) {
        this.productsApi = productsApi;
    }

    public Flowable<List<Product>> loadProductsFromWeb(){
        Flowable<List<Product>> data=productsApi.getUser();
        return data;
    }
}
