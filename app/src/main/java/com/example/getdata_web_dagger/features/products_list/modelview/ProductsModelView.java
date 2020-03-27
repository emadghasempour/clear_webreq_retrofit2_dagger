package com.example.getdata_web_dagger.features.products_list.modelview;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.getdata_web_dagger.features.products_list.datasource.ProductsApi;
import com.example.getdata_web_dagger.features.products_list.model.Product;
import com.example.getdata_web_dagger.features.products_list.repository.ProductsRepostory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProductsModelView extends ViewModel {
    private static final String TAG = "ProductsModelView";
    private MediatorLiveData<Resource<List<Product>>> products;
    private ProductsRepostory productsRepostory;

    @Inject
    public ProductsModelView(ProductsRepostory productsRepostory) {
        this.productsRepostory = productsRepostory;
        Log.d(TAG, "ProductsModelView: working");
    }
    public LiveData<Resource<List<Product>>> observeProducts(){
        if(products==null){
            products=new MediatorLiveData<>();
            products.setValue(Resource.loading((List<Product>) null));
            Log.d(TAG, "observeProducts: loading");
            final LiveData<Resource<List<Product>>> source= LiveDataReactiveStreams.fromPublisher(
                    productsRepostory.getProductsData()
                            .map(new Function<List<Product>, Resource<List<Product>>>() {
                                @Override
                                public Resource<List<Product>> apply(List<Product> products) throws Exception {
                                    if(products.size() > 0){
                                        if(products.get(0).getId() == -1){
                                            return Resource.error("Something went wrong", null);
                                        }
                                    }
                                    return Resource.success(products);
                                }
                            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()));
            products.addSource(source, new Observer<Resource<List<Product>>>() {
                @Override
                public void onChanged(Resource<List<Product>> listResource) {
                    products.setValue(listResource);
                    products.removeSource(source);
                }
            });
        }
        return products;
    }
}
