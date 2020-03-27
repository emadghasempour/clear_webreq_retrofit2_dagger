package com.example.getdata_web_dagger;

import android.content.Context;

public class ClassUnderTest {
    Context context;

    public ClassUnderTest(Context context) {
        this.context = context;
    }

    String  getStr(){
       return context.getString(R.string.hello_world);
    }
}
