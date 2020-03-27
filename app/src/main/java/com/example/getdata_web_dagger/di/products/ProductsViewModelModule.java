package com.example.getdata_web_dagger.di.products;

import androidx.lifecycle.ViewModel;

import com.example.getdata_web_dagger.di.ViewModelKey;
import com.example.getdata_web_dagger.features.products_list.modelview.ProductsModelView;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ProductsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductsModelView.class)
    public abstract ViewModel bindAuthViewModel(ProductsModelView productsModelView);
}
