package com.muaz.testapp.testproject.ui.company_list;

import com.muaz.testapp.testproject.base.BasePresenter;
import com.muaz.testapp.testproject.base.IBaseView;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Me;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by muazekici on 20.10.2018.
 */
@ActivityScope
public class CompanyListPresenter<V extends CompanyListContract.View,I extends CompanyListInteractor> extends BasePresenter<V,I>
                implements CompanyListContract.Presenter<V,I>{


    private CompanyListInteractor mCompanyListInteractor;

    @Inject
    public CompanyListPresenter(I companyListInteractor){
        super(companyListInteractor);
        mCompanyListInteractor = companyListInteractor;
    }

    @Override
    public void loadCompanies() {
        getView().showLoading();
        mCompanyListInteractor.getMyInfo(new DisposableSingleObserver<Me>() {
            @Override
            public void onSuccess(Me me) {
                getView().loadCompanies(me.getCompanies());
                getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
            }
        });

    }

    @Override
    public void companySelected(int id) {
        getView().showExpenses(id);
    }
}
