package com.muaz.testapp.testproject.data_manager.network_manager.modals;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muazekici on 18.10.2018.
 */

public class Token implements Serializable {

    @SerializedName("access_token")
    String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
