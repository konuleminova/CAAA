package com.crocusoft.androidarch.api;

import com.crocusoft.androidarch.model.LoginRequest;
import com.crocusoft.androidarch.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Asus on 2/13/2018.
 */

public interface ApiInterface {
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
