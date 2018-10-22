package com.muaz.testapp.testproject.ui.bill_list;

import com.muaz.testapp.testproject.base.BaseInteractor;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.CompanyExpenses;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;
import com.muaz.testapp.testproject.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by muazekici on 21.10.2018.
 */

@ActivityScope
public class BillListInteractor extends BaseInteractor{

    @Inject
    public BillListInteractor(INetworkManager networkManager, ISharedPrefManager sharedPrefManager, ISchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(networkManager, sharedPrefManager, schedulerProvider, compositeDisposable);
    }

    void getCompanyExpenses(int companyId, DisposableSingleObserver<CompanyExpenses> observer){
        Single<CompanyExpenses> call = getNetworkManager().getNetworkService().getCompanyExpenses(companyId)
                .observeOn(getSchedulerProvider().schedulerUI());

        addDisposable(call.subscribeWith(observer));
    }
}
