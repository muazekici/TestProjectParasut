package com.muaz.testapp.testproject.ui.login;

import com.muaz.testapp.testproject.base.IBasePresenter;
import com.muaz.testapp.testproject.base.IBaseView;

/**
 * Created by muazekici on 17.10.2018.
 */

public interface LoginContract {

    interface View extends IBaseView{

        void loginSuccessful();
        void loginUnsuccessful();
        void userHasToken();

    }

    interface Presenter<V extends View,I extends LoginInteractor> extends IBasePresenter<V,I> {

        void loginUser(String userName,String password,boolean isRemembered);
        void doesUserHaveToken();
    }
}
