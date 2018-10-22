package com.muaz.testapp.testproject.data_manager.sharedpref_manager;

/**
 * Created by muazekici on 17.10.2018.
 */

public interface TokenStorage {

    void saveToken(String authToken);

    String getToken();

}
