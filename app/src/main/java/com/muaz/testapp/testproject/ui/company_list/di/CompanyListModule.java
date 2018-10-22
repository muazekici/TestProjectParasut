package com.muaz.testapp.testproject.ui.company_list.di;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityContext;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.ui.company_list.CompanyListActivity;
import com.muaz.testapp.testproject.ui.company_list.CompanyListContract;
import com.muaz.testapp.testproject.ui.company_list.CompanyListInteractor;
import com.muaz.testapp.testproject.ui.company_list.CompanyListPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by muazekici on 20.10.2018.
 */

@Module
public class CompanyListModule {


    private AppCompatActivity mActivity;

    public CompanyListModule(CompanyListActivity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }


    @Provides
    @ActivityScope
    CompanyListContract.Presenter<CompanyListContract.View,CompanyListInteractor> provideCompanyListPresenter(
            CompanyListPresenter<CompanyListContract.View,CompanyListInteractor> presenter    ){
        return presenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
                return new CompositeDisposable();
    }
}
