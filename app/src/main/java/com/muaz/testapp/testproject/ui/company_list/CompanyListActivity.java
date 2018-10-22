package com.muaz.testapp.testproject.ui.company_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.muaz.testapp.testproject.R;
import com.muaz.testapp.testproject.base.BaseActivity;
import com.muaz.testapp.testproject.base.BaseApp;
import com.muaz.testapp.testproject.data_manager.network_manager.modals.Company;
import com.muaz.testapp.testproject.ui.bill_list.BillListActivity;
import com.muaz.testapp.testproject.ui.company_list.adapter.CompanyListAdapter;
import com.muaz.testapp.testproject.ui.company_list.di.CompanyListModule;
import com.muaz.testapp.testproject.ui.company_list.di.DaggerCompanyListActivityComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muazekici on 20.10.2018.
 */

public class CompanyListActivity extends BaseActivity implements CompanyListContract.View {



    public static void newIntent(Context context) {
        context.startActivity(new Intent(context, CompanyListActivity.class));
    }

    public static void newIntentWithClear(Context context) {
        Intent intent = new Intent(context, CompanyListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Inject
    CompanyListContract.Presenter<CompanyListContract.View, CompanyListInteractor> mPresenter;


    @BindView(R.id.rv_company_list)
    RecyclerView rvCompanyList;

    private CompanyListAdapter mAdapter;
    private List<Company> mCompanyList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        ButterKnife.bind(this);

        DaggerCompanyListActivityComponent.builder().companyListModule(new CompanyListModule(this))
                .appComponent(((BaseApp) getApplicationContext()).getAppComponent()).build().inject(this);

        mPresenter.onAttach(this);
        init();
        mPresenter.loadCompanies();
    }

    private void init() {
        mCompanyList = new ArrayList<>();
        mAdapter = new CompanyListAdapter(mCompanyList, new CompanyListAdapter.CompanySelectedListener() {
            @Override
            public void onCompanySelected(int position, int companyId) {
                mPresenter.companySelected(companyId);
            }
        });
        rvCompanyList.setAdapter(mAdapter);
    }

    @Override
    public void loadUser() {

    }

    @Override
    public void loadCompanies(List<Company> companies) {
        mCompanyList.addAll(companies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showExpenses(int id) {
        BillListActivity.newIntent(this,id);
    }


    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
