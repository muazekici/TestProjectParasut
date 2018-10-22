package com.muaz.testapp.testproject.ui.company_list;

import com.muaz.testapp.testproject.base.BaseInteractor;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.data_manager.network_manager.INetworkManager;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Me;
import com.muaz.testapp.testproject.data_manager.sharedpref_manager.ISharedPrefManager;
import com.muaz.testapp.testproject.utils.rx.ISchedulerProvider;
import com.muaz.testapp.testproject.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by muazekici on 20.10.2018.
 */

@ActivityScope
public class CompanyListInteractor extends BaseInteractor {

    @Inject
    public CompanyListInteractor(INetworkManager networkManager, ISharedPrefManager sharedPrefManager, ISchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(networkManager, sharedPrefManager, schedulerProvider, compositeDisposable);
    }

    public void getMyInfo(DisposableSingleObserver<Me> observer){
        Single<Me> call = getNetworkManager().getNetworkService().getMyInfo().observeOn(getSchedulerProvider().schedulerUI());

        addDisposable(call.subscribeWith(observer));
    }
}
