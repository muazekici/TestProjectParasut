package com.muaz.testapp.testproject.dagger_di.components;

import android.app.Application;
import android.content.Context;


import com.muaz.testapp.testproject.base.BaseApp;
import com.muaz.testapp.testproject.dagger_di.modules.AppModule;
import com.muaz.testapp.testproject.dagger_di.modules.NetworkModule;
import com.muaz.testapp.testproject.dagger_di.modules.SharedPreferencesModule;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ApplicationContext;
import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.network_manager.NetworkManager;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;
import com.muaz.testapp.testproject.utils.rx.ISchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by muazekici on 16.07.2018.
 */

@Singleton
@Component(modules = {NetworkModule.class,AppModule.class, SharedPreferencesModule.class})
public interface AppComponent {

    void inject(BaseApp baseApp);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    INetworkManager getNetworkManager();

    ISharedPrefManager getSharedPrefManager();

    ISchedulerProvider getSchedulerProvider();


}
