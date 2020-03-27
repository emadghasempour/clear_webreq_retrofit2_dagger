package com.example.getdata_web_dagger.di;

import androidx.lifecycle.ViewModelProvider;

import com.example.getdata_web_dagger.features.products_list.modelview.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
