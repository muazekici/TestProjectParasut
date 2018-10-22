package com.muaz.testapp.testproject.base;

/**
 * Created by muazekici on 15.07.2018.
 */

public interface IBasePresenter<V extends IBaseView,I extends IBaseInteractor> {

    void onAttach(V view);

    void detachView();

    boolean isViewAvailable();

    V getView();

    I getInteractor();


}
