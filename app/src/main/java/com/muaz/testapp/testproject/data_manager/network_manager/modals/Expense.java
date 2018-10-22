package com.muaz.testapp.testproject.data_manager.network_manager.modals;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muazekici on 21.10.2018.
 */

public class Expense implements Serializable {

    int id;
    String description;
    @SerializedName("net_total")
    String netTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(String netTotal) {
        this.netTotal = netTotal;
    }
}
