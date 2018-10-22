package com.muaz.testapp.testproject.ui.login.di;

import com.muaz.testapp.testproject.dagger_di.components.AppComponent;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.ui.login.LoginActivity;

import dagger.Component;

/**
 * Created by muazekici on 17.10.2018.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginActivityModule.class)
public interface LoginActivityComponent {


    void inject(LoginActivity activity);
}
