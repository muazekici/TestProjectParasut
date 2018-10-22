package com.muaz.testapp.testproject.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.muaz.testapp.testproject.ui.login.LoginActivity;

import javax.inject.Inject;

/**
 * Created by muazekici on 15.07.2018.
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {

    ProgressDialog progressDialog;
    @Override
    public void showLoading() {
        hideLoading();
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.show();

    }

    @Override
    public void hideLoading() {

        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.cancel();
        }

    }

    @Override
    public void onAuthError() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }




}
