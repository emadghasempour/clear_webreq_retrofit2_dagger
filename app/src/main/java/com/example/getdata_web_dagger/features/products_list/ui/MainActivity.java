package com.example.getdata_web_dagger.features.products_list.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.example.getdata_web_dagger.R;
import com.example.getdata_web_dagger.features.products_list.datasource.ProductsApi;
import com.example.getdata_web_dagger.features.products_list.model.Product;
import com.example.getdata_web_dagger.features.products_list.modelview.ProductsModelView;
import com.example.getdata_web_dagger.features.products_list.modelview.Resource;
import com.example.getdata_web_dagger.features.products_list.modelview.ViewModelProviderFactory;

import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends DaggerAppCompatActivity {
    private static final String TAG = "MainActivity";
    @Inject
    ProductsApi productsApi;

    @Inject
    ViewModelProviderFactory providerFactory;

    ProductsModelView productsModelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsModelView = ViewModelProviders.of(this,providerFactory).get(ProductsModelView.class);

        productsModelView.observeProducts().observe(this, new Observer<Resource<List<Product>>>() {
            @Override
            public void onChanged(Resource<List<Product>> listResource) {
                switch (listResource.status){
                    case ERROR:
                        Log.d(TAG, "onChanged: error");
                        break;
                    case LOADING:
                        Log.d(TAG, "onChanged: loading");
                        break;
                    case SUCCESS:
                        Log.d(TAG, "onChanged: success");
                        Log.d(TAG, "onChanged: "+listResource.data.size());
                }
            }
        });



    }
}
