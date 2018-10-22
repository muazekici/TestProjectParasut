package com.muaz.testapp.testproject.base;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by muazekici on 15.07.2018.
 */

public class BasePresenter<V extends IBaseView,I extends IBaseInteractor>  implements IBasePresenter<V,I> ,
        BaseInteractor.NetworkStatusListener{


    private WeakReference<V> mViewRef;
    private I mInteractorRef;

    public BasePresenter(I baseInteractor){
        mInteractorRef = baseInteractor;
        mInteractorRef.setNetworkListener(this);
    }

    @Override
    public void onAttach(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }

        if(mInteractorRef != null){
            mInteractorRef.disposeSubscriptions();
            mInteractorRef.clearNetworkListener();
        }
    }

    @Override
    public boolean isViewAvailable() {
        return mViewRef != null && mViewRef.get() != null;
    }

    @Nullable
    @Override
    public V getView() {
        return mViewRef == null ? null : mViewRef.get();
    }

    @Nullable
    @Override
    public I getInteractor() {
        return mInteractorRef == null ? null : mInteractorRef;
    }


    @Override
    public void onAuthError() {
        mInteractorRef.clearAuthToken();
        if(getView() != null){
            getView().onAuthError();
        }
    }
}
