package com.muaz.testapp.testproject.ui.company_list.di;

import com.muaz.testapp.testproject.dagger_di.components.AppComponent;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.ui.company_list.CompanyListActivity;
import com.muaz.testapp.testproject.ui.login.di.LoginActivityModule;

import dagger.Component;

/**
 * Created by muazekici on 20.10.2018.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = CompanyListModule.class)
public interface CompanyListActivityComponent {

    void inject(CompanyListActivity activity);
}
