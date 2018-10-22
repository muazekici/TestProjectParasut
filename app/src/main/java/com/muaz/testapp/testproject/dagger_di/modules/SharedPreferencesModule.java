package com.muaz.testapp.testproject.dagger_di.modules;

import android.content.Context;
import android.content.SharedPreferences;


import com.muaz.testapp.testproject.dagger_di.qualifiers.ApplicationContext;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.SharedPrefManager;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.TokenStorage;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by muazekici on 16.07.2018.
 */

@Module
public class SharedPreferencesModule {


    private static final String SHARED_PREFERENCES_NAME = "shared_preferences_name";


    @Named(SHARED_PREFERENCES_NAME)
    @Provides
    String provideBaseUrl() {
        return "muaz_preferences";
    }


    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(@ApplicationContext Context context,
                                               @Named(SHARED_PREFERENCES_NAME) String sharedPrefName){
        return context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
    }


    @Singleton
    @Provides
    ISharedPrefManager provideSharedPrefManager(SharedPrefManager sharedPrefManager){
        return sharedPrefManager;
    }

    @Singleton
    @Provides
    TokenStorage provideTokenStorage(SharedPrefManager sharedPrefManager){
        return sharedPrefManager;
    }


}
