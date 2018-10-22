package com.muaz.testapp.testproject.base;



import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by muazekici on 22.07.2018.
 */

public interface IBaseInteractor {


    INetworkManager getNetworkManager();

    ISharedPrefManager getSharedPrefManager();

    void updateAuthToken(String authToken);

    boolean isThereToken();

    void disposeSubscriptions();

    void addDisposable(Disposable disposable);

    void setNetworkListener(BaseInteractor.NetworkStatusListener listener);

    void clearNetworkListener();

    void clearAuthToken();

}
