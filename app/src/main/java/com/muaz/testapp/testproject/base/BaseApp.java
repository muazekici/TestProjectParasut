package com.muaz.testapp.testproject.base;

import android.app.Application;


import com.muaz.testapp.testproject.dagger_di.components.AppComponent;
import com.muaz.testapp.testproject.dagger_di.components.DaggerAppComponent;
import com.muaz.testapp.testproject.dagger_di.modules.AppModule;
import com.muaz.testapp.testproject.dagger_di.modules.NetworkModule;

/**
 * Created by muazekici on 16.07.2018.
 */

public class BaseApp extends Application {



    private AppComponent mAppComponent;



    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule()).build();



    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
