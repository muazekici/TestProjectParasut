package com.muaz.testapp.testproject.ui.bill_list;

import com.muaz.testapp.testproject.base.BasePresenter;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.CompanyExpenses;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by muazekici on 21.10.2018.
 */
@ActivityScope
public class BillListPresenter<V extends BillListContract.View,I extends BillListInteractor> extends BasePresenter<V,I>
            implements BillListContract.Presenter<V,I>{

    @Inject
    public BillListPresenter(I baseInteractor) {
        super(baseInteractor);
    }

    @Override
    public void fetchBills(int companyId) {
        if(companyId == 0){
            return;
        }
        getView().showLoading();
        getInteractor().getCompanyExpenses(companyId, new DisposableSingleObserver<CompanyExpenses>() {
            @Override
            public void onSuccess(CompanyExpenses companyExpenses) {
                getView().setBills(companyExpenses.getExpenses());
                getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
            }
        });
    }
}
