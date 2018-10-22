package com.muaz.testapp.testproject.data_manager.network_manager;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by muazekici on 16.07.2018.
 */

public class HeaderInterceptor implements Interceptor {

    private static final String ACCEPT_HEADER = "Accept";
    private static final String JSON_TYPE = "application/json";
    private static final String TOKEN_NAME = "Authorization";
    private String authToken = "";

    @Override
    public synchronized Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder().addHeader(ACCEPT_HEADER, JSON_TYPE)
                .addHeader(TOKEN_NAME,"Bearer "+authToken).build();
        return chain.proceed(request);
    }

    public synchronized void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
