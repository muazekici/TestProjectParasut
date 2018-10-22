package com.muaz.testapp.testproject.dagger_di.modules;

import android.content.Context;

import com.muaz.testapp.testproject.dagger_di.qualifiers.ApplicationContext;
import com.muaz.testapp.testproject.data_manager.network_manager.AuthorizationInterceptor;
import com.muaz.testapp.testproject.data_manager.network_manager.HeaderInterceptor;
import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.network_manager.NetworkManager;
import com.muaz.testapp.testproject.data_manager.network_manager.NetworkService;
import com.muaz.testapp.testproject.utils.RXBus;
import com.muaz.testapp.testproject.utils.rx.SchedulerProvider;


import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by muazekici on 16.07.2018.
 */

@Module
public class NetworkModule {

    private static final String BASE_URL = "base_url";
    private static final String CACHE_SIZE = "cache_size";
    private static final String TIMEOUT_MILLIS = "timeout_millis";
    private static final String TIMEOUT_UNIT = "timeout_unit";



    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return "https://api.parasut.com/";
    }

    @Provides
    @Named(CACHE_SIZE)
    int provideCacheSize() {
        return 10*1024*1024;
    }

    @Provides
    @Named(TIMEOUT_MILLIS)
    long provideTimeOutMillis() {
        return 10000;
    }

    @Provides
    @Named(TIMEOUT_UNIT)
    TimeUnit provideTimeOutUnit() {
        return TimeUnit.MILLISECONDS;
    }

    @Provides
    @Singleton
    HeaderInterceptor provideHeaderInterceptor() {
        return new HeaderInterceptor();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    AuthorizationInterceptor provideAuthInterceptor(RXBus rxBus){
        return new AuthorizationInterceptor(rxBus);
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(HeaderInterceptor headerInterceptor,
                                   HttpLoggingInterceptor httpInterceptor,
                                   AuthorizationInterceptor authInterceptor,
                                   @ApplicationContext Context context,
                                   @Named(CACHE_SIZE) int cacheSize,
                                   @Named(TIMEOUT_MILLIS) long timeOutMillis,
                                   @Named(TIMEOUT_UNIT) TimeUnit timeOutUnit) {
        return new OkHttpClient.Builder().addInterceptor(headerInterceptor)
                .addInterceptor(httpInterceptor)
                .addInterceptor(authInterceptor)
                /*.cache(new Cache(context.getCacheDir(),cacheSize))
                .readTimeout(timeOutMillis,timeOutUnit)
                .writeTimeout(timeOutMillis,timeOutUnit)
                .connectTimeout(timeOutMillis,timeOutUnit)*/
                .build();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideRxJavaAdapterFactory(SchedulerProvider schedulerProvider) {
        return RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.schedulerIO());
        //return RxJava2CallAdapterFactory.createAsync();


    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl, Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    NetworkService provideNetworkService(Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    INetworkManager provideNetworkManager(NetworkManager networkManager){
        return networkManager;
    }
}
