package com.example.getdata_web_dagger.features.products_list.repository;

import com.example.getdata_web_dagger.features.products_list.datasource.NetworkDataSource;
import com.example.getdata_web_dagger.features.products_list.model.Product;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class ProductsRepostory {
    NetworkDataSource networkDataSource;

    @Inject
    public ProductsRepostory(NetworkDataSource networkDataSource) {
        this.networkDataSource = networkDataSource;
    }

    public Flowable<List<Product>> getProductsData(){
        return networkDataSource.loadProductsFromWeb();
    }
}
