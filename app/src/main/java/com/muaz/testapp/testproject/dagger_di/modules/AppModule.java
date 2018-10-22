package com.muaz.testapp.testproject.dagger_di.modules;

import android.app.Application;
import android.content.Context;


import com.muaz.testapp.testproject.dagger_di.qualifiers.ApplicationContext;
import com.muaz.testapp.testproject.utils.RXBus;
import com.muaz.testapp.testproject.utils.rx.ISchedulerProvider;
import com.muaz.testapp.testproject.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

/**
 * Created by muazekici on 16.07.2018.
 */

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider(){
        return new SchedulerProvider();
    }

    @Provides
    @Singleton
    ISchedulerProvider provideISchedulerProvider(SchedulerProvider schedulerProvider){
        return schedulerProvider;
    }

    @Provides
    RXBus provideRxBus(){
        return new RXBus();
    }



}
