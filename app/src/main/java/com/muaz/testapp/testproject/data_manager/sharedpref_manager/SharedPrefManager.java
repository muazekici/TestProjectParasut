package com.muaz.testapp.testproject.data_manager.sharedpref_manager;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by muazekici on 15.07.2018.
 */

@Singleton
public class SharedPrefManager implements ISharedPrefManager ,TokenStorage{

    private static final String AUTH_TOKEN_KEY = "auth_token";
    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefManager(SharedPreferences sharedPreferences){
        mSharedPreferences = sharedPreferences;


    }

    @Override
    public void saveToken(String authToken) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(AUTH_TOKEN_KEY,authToken);
        editor.commit();
    }

    @Override
    public String getToken() {
        String token = mSharedPreferences.getString(AUTH_TOKEN_KEY,"");
        return token;
    }


}
