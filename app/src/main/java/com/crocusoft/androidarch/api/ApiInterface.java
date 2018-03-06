package com.crocusoft.androidarch.api;

import com.crocusoft.androidarch.model.User;
import com.crocusoft.androidarch.model.UserDetailsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Asus on 2/13/2018.
 */

public interface ApiInterface {
    @POST("login")
    Call<User> login(@Body User user);
}
