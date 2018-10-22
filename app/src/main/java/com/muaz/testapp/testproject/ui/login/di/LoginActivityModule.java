package com.muaz.testapp.testproject.ui.login.di;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityContext;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.ui.login.LoginContract;
import com.muaz.testapp.testproject.ui.login.LoginInteractor;
import com.muaz.testapp.testproject.ui.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by muazekici on 17.10.2018.
 */

@Module
public class LoginActivityModule {

    private AppCompatActivity mActivity;

    public LoginActivityModule(AppCompatActivity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    LoginContract.Presenter<LoginContract.View,LoginInteractor> provideLoginPresenter(
            LoginPresenter<LoginContract.View,LoginInteractor> presenter){
        return presenter;
    }

    @Provides
    CompositeDisposable provideDisposable(){
                return new CompositeDisposable();
    }



}
