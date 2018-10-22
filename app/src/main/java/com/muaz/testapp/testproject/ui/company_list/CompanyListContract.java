package com.muaz.testapp.testproject.ui.company_list;

import com.muaz.testapp.testproject.base.IBasePresenter;
import com.muaz.testapp.testproject.base.IBaseView;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Company;
import com.muaz.testapp.testproject.ui.login.LoginContract;
import com.muaz.testapp.testproject.ui.login.LoginInteractor;

import java.util.List;

/**
 * Created by muazekici on 20.10.2018.
 */

public interface CompanyListContract {
    interface View extends IBaseView {

        void loadUser();
        void loadCompanies(List<Company> companies);
        void showExpenses(int id);

    }

    interface Presenter<V extends CompanyListContract.View,I extends CompanyListInteractor> extends IBasePresenter<V,I> {

        void loadCompanies();

        void companySelected(int id);

    }
}
