package com.crocusoft.androidarch.model;

import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 2/13/2018.
 */

public class LoginRequest {
    @SerializedName("Username")
    private String username;
    @SerializedName("Password")
    private String password;
    @SerializedName("ApiKey")
    private String apikey;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", apikey='" + apikey + '\'' +
                '}';
    }
}
