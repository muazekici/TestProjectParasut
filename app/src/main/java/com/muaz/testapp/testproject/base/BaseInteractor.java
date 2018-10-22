package com.muaz.testapp.testproject.base;



import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;
import com.muaz.testapp.testproject.utils.rx.ISchedulerProvider;

import java.util.function.Consumer;
import java.util.function.Function;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by muazekici on 22.07.2018.
 */

public class BaseInteractor implements IBaseInteractor {


    public interface NetworkStatusListener{
        void onAuthError();
    }

    private NetworkStatusListener mNetworkStatusListener;

    private final INetworkManager mNetworkManager;
    private final ISharedPrefManager mSharedPrefManager;
    private final ISchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    public BaseInteractor(INetworkManager networkManager,
                          ISharedPrefManager sharedPrefManager,
                          ISchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable){

        this.mNetworkManager = networkManager;
        this.mSharedPrefManager = sharedPrefManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;

    }


    @Override
    public INetworkManager getNetworkManager() {
        return mNetworkManager;
    }

    @Override
    public ISharedPrefManager getSharedPrefManager() {
        return mSharedPrefManager;
    }


    @Override
    public void updateAuthToken(String authToken) {
        mNetworkManager.updateAuthToken(authToken);
    }

    @Override
    public boolean isThereToken() {
        return mNetworkManager.isThereToken();
    }

    @Override
    public void disposeSubscriptions() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void setNetworkListener(NetworkStatusListener listener) {
        mNetworkStatusListener = listener;
        mNetworkManager.getAuthErrorBus().observeOn(getSchedulerProvider().schedulerUI())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        mNetworkStatusListener.onAuthError();
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void clearNetworkListener() {
        mNetworkStatusListener = null;
    }

    @Override
    public void clearAuthToken() {
        mNetworkManager.updateAuthToken("");
    }

    public ISchedulerProvider getSchedulerProvider(){
        return mSchedulerProvider;
    }
}
