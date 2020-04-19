package com.example.getdata_web_dagger;

import com.example.getdata_web_dagger.features.products_list.datasource.NetworkDataSource;
import com.example.getdata_web_dagger.features.products_list.datasource.ProductsApi;
import com.example.getdata_web_dagger.features.products_list.model.Product;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import org.junit.runner.RunWith;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Example {
    NetworkDataSource mockNetworkDataSource= mock(NetworkDataSource.class);
    @Inject ProductsApi mockProductsApi;

    @Test
    public void checkNetwork(){
        when(mockNetworkDataSource.loadProductsFromWeb()).thenReturn(null);
        Flowable<List<Product>> arr = mockNetworkDataSource.loadProductsFromWeb();
        assertEquals(null,arr);
        //verify(mockProductsApi.getUser());
    }
}
