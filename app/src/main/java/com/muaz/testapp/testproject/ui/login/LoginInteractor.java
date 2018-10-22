package com.muaz.testapp.testproject.ui.login;

import android.util.Log;

import com.muaz.testapp.testproject.BuildConfig;
import com.muaz.testapp.testproject.base.BaseInteractor;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Token;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;
import com.muaz.testapp.testproject.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by muazekici on 17.10.2018.
 */

@ActivityScope
public class LoginInteractor extends BaseInteractor {



    @Inject
    public LoginInteractor(INetworkManager networkManager, ISharedPrefManager sharedPrefManager, ISchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(networkManager, sharedPrefManager, schedulerProvider,compositeDisposable);
    }

    public void loginUser(String userName, String password, boolean isRemembered,DisposableSingleObserver<Token> observer){
        Single<Token> call = getNetworkManager().getNetworkService().loginUser(userName,password,
                BuildConfig.AUTH_CLIENT_ID,BuildConfig.AUTH_CLIENT_SECRET);

        
        addDisposable(call.observeOn(getSchedulerProvider().schedulerUI())
                .subscribeWith(observer));
    }
}
