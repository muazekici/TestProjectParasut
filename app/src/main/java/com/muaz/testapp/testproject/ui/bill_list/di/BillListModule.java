package com.muaz.testapp.testproject.ui.bill_list.di;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityContext;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.ui.bill_list.BillListActivity;
import com.muaz.testapp.testproject.ui.bill_list.BillListContract;
import com.muaz.testapp.testproject.ui.bill_list.BillListInteractor;
import com.muaz.testapp.testproject.ui.bill_list.BillListPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by muazekici on 21.10.2018.
 */

@Module
public class BillListModule {

    private AppCompatActivity mActivity;

    public BillListModule(BillListActivity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    BillListContract.Presenter<BillListContract.View,BillListInteractor> provideBillListPresenter(
            BillListPresenter<BillListContract.View,BillListInteractor> presenter){
        return presenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
                return new CompositeDisposable();
    }
}
