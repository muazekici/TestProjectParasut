package com.muaz.testapp.testproject.data_manager.network_manager.modals;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muazekici on 21.10.2018.
 */

public class Company implements Serializable {


    int id;
    String name;
    @SerializedName("is_owner")
    boolean isOwner;
    boolean accessible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
}
