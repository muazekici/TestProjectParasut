package com.muaz.testapp.testproject.ui.bill_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.muaz.testapp.testproject.R;
import com.muaz.testapp.testproject.base.BaseActivity;
import com.muaz.testapp.testproject.base.BaseApp;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Expense;
import com.muaz.testapp.testproject.ui.bill_list.adapter.BillListAdapter;
import com.muaz.testapp.testproject.ui.bill_list.di.BillListModule;
import com.muaz.testapp.testproject.ui.bill_list.di.DaggerBillListActivityComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muazekici on 21.10.2018.
 */

public class BillListActivity extends BaseActivity implements BillListContract.View {

    private static final String COMPANY_ID = "company_id";


    public static void newIntent(Context context, int companyId) {
        Intent intent = new Intent(context, BillListActivity.class);
        intent.putExtra(COMPANY_ID, companyId);
        context.startActivity(intent);
    }

    @Inject
    BillListContract.Presenter<BillListContract.View, BillListInteractor> mPresenter;
    @BindView(R.id.rv_bill_list)
    RecyclerView rvBillList;

    private BillListAdapter mAdapter;
    private List<Expense> mExpenseList;
    private int mCompanyId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);
        ButterKnife.bind(this);

        DaggerBillListActivityComponent.builder().billListModule(new BillListModule(this))
                .appComponent(((BaseApp) getApplicationContext()).getAppComponent()).build().inject(this);

        mPresenter.onAttach(this);

        init();
    }

    private void init() {
        if (getIntent().getIntExtra(COMPANY_ID, 0) != 0) {
            mCompanyId = getIntent().getIntExtra(COMPANY_ID, -1);
        }
        mExpenseList = new ArrayList<>();
        mAdapter = new BillListAdapter(mExpenseList);
        rvBillList.setAdapter(mAdapter);

        mPresenter.fetchBills(mCompanyId);
    }

    @Override
    public void setBills(List<Expense> expenseList) {
        mExpenseList.addAll(expenseList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }


}
