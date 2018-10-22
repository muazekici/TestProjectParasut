package com.muaz.testapp.testproject.data_manager.network_manager;


import android.util.Log;

import com.muaz.testapp.testproject.data_manager.network_manager.events.AuthorizationErrorEvent;
import com.muaz.testapp.testproject.utils.RXBus;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by muazekici on 21.10.2018.
 */

public class AuthorizationInterceptor implements Interceptor {

    private RXBus mRxBus;

    @Inject
    public AuthorizationInterceptor(RXBus rxBus){
        mRxBus = rxBus;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        Log.d("AUTH","ENTER");
        if(response.code() == 401 || response.code() == 403){
            mRxBus.sendEvent(new AuthorizationErrorEvent());
            Log.d("AUTH","ERROR");

        }

        return response;
    }

    public Observable<Object> getErrorEventBus(){
        return mRxBus.getBusObservable();
    }
}
