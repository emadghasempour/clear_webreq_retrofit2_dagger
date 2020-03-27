package com.example.getdata_web_dagger.di;

import com.example.getdata_web_dagger.features.products_list.ui.MainActivity;
import com.example.getdata_web_dagger.di.products.ProductsModule;
import com.example.getdata_web_dagger.di.products.ProductsViewModelModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(
            modules = {ProductsModule.class, ProductsViewModelModule.class}
    )
    abstract MainActivity contributeAuthActivity();
}
