package com.example.getdata_web_dagger.di.products;

import com.example.getdata_web_dagger.features.products_list.datasource.NetworkDataSource;
import com.example.getdata_web_dagger.features.products_list.datasource.ProductsApi;
import com.example.getdata_web_dagger.features.products_list.repository.ProductsRepostory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ProductsModule {
    @Provides
    static ProductsApi provideProductsApi(Retrofit retrofit){
        return retrofit.create(ProductsApi.class);
    }

    @Provides
    static NetworkDataSource provideNetworkDataSource(ProductsApi productsApi){
        return new NetworkDataSource(productsApi);
    }

    @Provides
    static ProductsRepostory provideProductsRepository(NetworkDataSource networkDataSource){
        return new ProductsRepostory(networkDataSource);
    }
}
