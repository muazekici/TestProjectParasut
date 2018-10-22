package com.muaz.testapp.testproject.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

import com.muaz.testapp.testproject.R;
import com.muaz.testapp.testproject.base.BaseActivity;
import com.muaz.testapp.testproject.base.BaseApp;
import com.muaz.testapp.testproject.ui.company_list.CompanyListActivity;
import com.muaz.testapp.testproject.ui.login.di.DaggerLoginActivityComponent;
import com.muaz.testapp.testproject.ui.login.di.LoginActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by muazekici on 17.10.2018.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginContract.Presenter<LoginContract.View, LoginInteractor> mLoginPresenter;

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);

        DaggerLoginActivityComponent.builder().loginActivityModule(new LoginActivityModule(this))
                .appComponent(((BaseApp) getApplicationContext()).getAppComponent()).build().inject(LoginActivity.this);
        mLoginPresenter.onAttach(LoginActivity.this);
        mLoginPresenter.doesUserHaveToken();

        etUsername.setText("muaz.ekici@hotmail.com");
        etPassword.setText("Asdqwe123.");
    }

    @Override
    public void loginSuccessful() {
        CompanyListActivity.newIntentWithClear(this);
    }

    @Override
    public void loginUnsuccessful() {

    }

    @Override
    public void userHasToken() {
        CompanyListActivity.newIntentWithClear(this);
    }

    @OnClick(R.id.tv_login_btn)
    public void onViewClicked() {

        mLoginPresenter.loginUser(etUsername.getText().toString(),
                etPassword.getText().toString(), true);

       // mLoginPresenter.loginUser("muaz.ekici@hotmail.com", "Asdqwe123.", true);
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.detachView();
        super.onDestroy();

    }
}
