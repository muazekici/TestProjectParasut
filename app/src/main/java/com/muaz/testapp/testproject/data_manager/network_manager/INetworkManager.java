package com.muaz.testapp.testproject.data_manager.network_manager;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by muazekici on 15.07.2018.
 */

public interface INetworkManager {


    NetworkService getNetworkService();

    void updateAuthToken(String authToken);

    boolean isThereToken();

    Observable<Object> getAuthErrorBus();
}
