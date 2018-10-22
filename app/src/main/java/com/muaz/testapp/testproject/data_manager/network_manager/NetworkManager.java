package com.muaz.testapp.testproject.data_manager.network_manager;


import com.muaz.testapp.testproject.data_manager.sharedpref_manager.TokenStorage;
import com.muaz.testapp.testproject.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by muazekici on 15.07.2018.
 */

@Singleton
public class NetworkManager implements INetworkManager {

    private NetworkService mNetworkService;
    private SchedulerProvider mSchedulerProvider;
    private HeaderInterceptor mHeaderInterceptor;
    private TokenStorage mTokenStorage;
    private AuthorizationInterceptor mAuthInterceptor;

    @Inject
    public NetworkManager(NetworkService networkService, SchedulerProvider schedulerProvider,
                          HeaderInterceptor headerInterceptor, AuthorizationInterceptor authorizationInterceptor,
                          TokenStorage tokenStorage){

        mNetworkService = networkService;
        mSchedulerProvider = schedulerProvider;
        mHeaderInterceptor = headerInterceptor;
        mTokenStorage = tokenStorage;
        mAuthInterceptor = authorizationInterceptor;
        mHeaderInterceptor.setAuthToken(mTokenStorage.getToken());
    }


    @Override
    public NetworkService getNetworkService() {
        return mNetworkService;
    }

    @Override
    public void updateAuthToken(String authToken) {
        mTokenStorage.saveToken(authToken);
        mHeaderInterceptor.setAuthToken(authToken);
    }

    @Override
    public boolean isThereToken() {
        return !mTokenStorage.getToken().equals("");
    }

    @Override
    public Observable<Object> getAuthErrorBus() {
        return mAuthInterceptor.getErrorEventBus();
    }
}
