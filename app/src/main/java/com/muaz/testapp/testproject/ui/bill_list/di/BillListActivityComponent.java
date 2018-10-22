package com.muaz.testapp.testproject.ui.bill_list.di;

import com.muaz.testapp.testproject.dagger_di.components.AppComponent;
import com.muaz.testapp.testproject.dagger_di.qualifiers.ActivityScope;
import com.muaz.testapp.testproject.ui.bill_list.BillListActivity;
import com.muaz.testapp.testproject.ui.company_list.di.CompanyListModule;

import dagger.Component;

/**
 * Created by muazekici on 21.10.2018.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = BillListModule.class)
public interface BillListActivityComponent {

    void inject(BillListActivity activity);
}
