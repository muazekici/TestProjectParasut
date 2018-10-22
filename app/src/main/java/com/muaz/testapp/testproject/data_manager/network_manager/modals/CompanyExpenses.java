package com.muaz.testapp.testproject.data_manager.network_manager.modals;

import java.io.Serializable;
import java.util.List;

/**
 * Created by muazekici on 21.10.2018.
 */

public class CompanyExpenses implements Serializable {

    List<Expense> expenses;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
