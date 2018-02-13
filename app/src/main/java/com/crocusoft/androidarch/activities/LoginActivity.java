package com.crocusoft.androidarch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.api.ApiClient;
import com.crocusoft.androidarch.api.ApiInterface;
import com.crocusoft.androidarch.model.LoginRequest;
import com.crocusoft.androidarch.model.LoginResponse;

import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void login() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("ceyhun-auditor");
        loginRequest.setPassword("12341234");
        loginRequest.setApikey("987654");
        apiInterface.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(retrofit2.Call<LoginResponse> call, Response<LoginResponse> response) {
                String getMessageId=String.valueOf(response.body().getMessageId());
                Toast.makeText(getBaseContext(), getMessageId, Toast.LENGTH_LONG).show();
                Log.e("konul",response.body().toString());
            }

            @Override
            public void onFailure(retrofit2.Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "fail", Toast.LENGTH_LONG).show();
            }
        });
    }
}
