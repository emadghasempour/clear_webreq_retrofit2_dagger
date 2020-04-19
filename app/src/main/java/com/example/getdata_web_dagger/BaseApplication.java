package com.example.getdata_web_dagger;

import android.app.Application;

import com.example.getdata_web_dagger.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


/**
 * Using MVVM architecture
 * the core is in image folder in project directory
 * have a {{@link com.example.getdata_web_dagger.features.products_list.datasource.NetworkDataSource}} as datasource
 * and pass it to {{@link com.example.getdata_web_dagger.features.products_list.repository.ProductsRepostory}}
 *
 *
 *  using dagger - rxJava2 - retrofit - testing modules - android jetpack
 *
 * {{@link com.example.getdata_web_dagger.features.products_list.modelview.ProductsModelView}}
 * in this class we used somthing like BLoC pattern in flutter to map different datas to states
 * all dependency injections placed in {@docRoot di} package
 *
 */
public class BaseApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).Build();

    }
}
