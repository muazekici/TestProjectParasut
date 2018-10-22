package com.muaz.testapp.testproject.ui.login;

import com.muaz.testapp.testproject.base.BaseInteractor;
import com.muaz.testapp.testproject.base.BasePresenter;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Token;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by muazekici on 17.10.2018.
 */
@ActivityScope
public class LoginPresenter<V extends LoginContract.View,I extends LoginInteractor> extends BasePresenter<V,I>
                implements LoginContract.Presenter<V,I> {


    private LoginInteractor mLoginInteractor;

    @Inject
    public LoginPresenter(I LoginInteractor){
        super(LoginInteractor);
        mLoginInteractor = getInteractor();
    }


    @Override
    public void loginUser(String userName, String password, boolean isRemembered) {
        getView().showLoading();
        mLoginInteractor.loginUser(userName, password, isRemembered, new DisposableSingleObserver<Token>() {
            @Override
            public void onSuccess(Token token) {
                if(isRemembered) {
                    mLoginInteractor.updateAuthToken(token.getAccessToken());
                }
                getView().hideLoading();
                getView().loginSuccessful();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                getView().loginUnsuccessful();
            }
        });

    }

    @Override
    public void doesUserHaveToken() {
        if(mLoginInteractor.isThereToken()) {
                getView().userHasToken();
        }
    }
}
