package com.muaz.testapp.testproject.ui.bill_list;

import com.muaz.testapp.testproject.base.IBasePresenter;
import com.muaz.testapp.testproject.base.IBaseView;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Expense;

import java.util.List;

/**
 * Created by muazekici on 21.10.2018.
 */

public interface BillListContract {

    interface View extends IBaseView{
        void setBills(List<Expense> expenseList);
    }

    interface Presenter<V extends View,I extends BillListInteractor> extends IBasePresenter<V,I>{
        void fetchBills(int companyId);
    }
}
