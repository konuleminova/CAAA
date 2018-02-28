package com.crocusoft.androidarch.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.api.ApiClient;
import com.crocusoft.androidarch.api.ApiInterface;
import com.crocusoft.androidarch.asynctask.AsyncTaskUtil;
import com.crocusoft.androidarch.model.LoginRequest;
import com.crocusoft.androidarch.model.LoginResponse;
import com.crocusoft.androidarch.utilities.SharedPreferenceUtils;

import retrofit2.Callback;
import retrofit2.Response;

import static com.crocusoft.androidarch.utilities.Constants.API_KEY;
import static com.crocusoft.androidarch.utilities.Constants.AUTHENTICATION_ISSUE;
import static com.crocusoft.androidarch.utilities.Constants.AUTHORIZATION_ISSUE;
import static com.crocusoft.androidarch.utilities.Constants.COULD_NOT_DELETE_SELF;
import static com.crocusoft.androidarch.utilities.Constants.DALC_EXCEPTION;
import static com.crocusoft.androidarch.utilities.Constants.DATABASE_EXCEPTION;
import static com.crocusoft.androidarch.utilities.Constants.DATA_NOT_FOUND;
import static com.crocusoft.androidarch.utilities.Constants.KEY_ID;
import static com.crocusoft.androidarch.utilities.Constants.KEY_TOKEN;
import static com.crocusoft.androidarch.utilities.Constants.NOT_VALIDATED_DATA;
import static com.crocusoft.androidarch.utilities.Constants.SUCCESSFULL;
import static com.crocusoft.androidarch.utilities.Constants.VIOLATION_FOREIGN_KEY;
import static com.crocusoft.androidarch.utilities.Constants.VIOLATION_UNIQUE_KEY;
import static com.crocusoft.androidarch.utilities.Constants.WRONG_API_KEY;
import static com.crocusoft.androidarch.utilities.Constants.WRONG_OLD_PASSWORD;
import static com.crocusoft.androidarch.utilities.Constants.WRONG_USERNAME_PASSWORD;
import static com.crocusoft.androidarch.utilities.Helper.setErrorMessage;

public class LoginActivity extends AppCompatActivity {
    Button btnSave;
    EditText editTextUsername, editTextPassword;
    SharedPreferenceUtils sharedPreferenceUtils;
    Integer id;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intiViews();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editTextUsername.getText().toString())) {
                    editTextUsername.setError(getResources().getString(R.string.error_username));
                    editTextUsername.requestFocus();
                } else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
                    editTextPassword.setError(getResources().getString(R.string.error_password));
                    editTextPassword.requestFocus();
                } else {
                    login();
                  // AsyncTaskUtil asyncTaskUtil=new AsyncTaskUtil(getApplicationContext());
                  // asyncTaskUtil.execute();
                }
            }
        });
    }

    public void intiViews() {
        sharedPreferenceUtils = new SharedPreferenceUtils(this);
        btnSave = (Button) findViewById(R.id.btnSave);
        editTextUsername = (EditText) findViewById(R.id.edittext_username);
        editTextPassword = (EditText) findViewById(R.id.edittext_password);
    }

    public void login() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(editTextUsername.getText().toString());
        loginRequest.setPassword(editTextPassword.getText().toString());
        loginRequest.setApikey(API_KEY);
        apiInterface.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(retrofit2.Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body().getId() != null) {
                    id = response.body().getId();
                    sharedPreferenceUtils.setIntegerData(KEY_ID, response.body().getId());
                    sharedPreferenceUtils.setStringData(KEY_TOKEN, response.body().getToken());
                    //sharedPreferenceUtils.clear();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.error_transactionID), Toast.LENGTH_LONG).show();
                }
                switch (response.body().getMessageId()) {
                    case 1000:
                        setErrorMessage(getBaseContext(), SUCCESSFULL);
                        break;
                    case 1001:
                        setErrorMessage(getBaseContext(), AUTHENTICATION_ISSUE);
                        break;
                    case 1002:
                        setErrorMessage(getBaseContext(), AUTHORIZATION_ISSUE);
                        break;
                    case 1003:
                        setErrorMessage(getBaseContext(), DATABASE_EXCEPTION);
                        break;
                    case 1004:
                        setErrorMessage(getBaseContext(), DALC_EXCEPTION);
                        break;
                    case 1005:
                        setErrorMessage(getBaseContext(), WRONG_USERNAME_PASSWORD);
                        break;
                    case 1006:
                        setErrorMessage(getBaseContext(), WRONG_API_KEY);
                        break;
                    case 1007:
                        setErrorMessage(getBaseContext(), NOT_VALIDATED_DATA);
                        break;
                    case 1008:
                        setErrorMessage(getBaseContext(), COULD_NOT_DELETE_SELF);
                        break;
                    case 1009:
                        setErrorMessage(getBaseContext(), VIOLATION_FOREIGN_KEY);
                        break;
                    case 1010:
                        setErrorMessage(getBaseContext(), WRONG_OLD_PASSWORD);
                        break;
                    case 1012:
                        setErrorMessage(getBaseContext(), DATA_NOT_FOUND);
                        break;
                    case 1013:
                        setErrorMessage(getBaseContext(), VIOLATION_UNIQUE_KEY);
                        break;
                }

            }

            @Override
            public void onFailure(retrofit2.Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), getResources().getString(R.string.system_fail), Toast.LENGTH_LONG).show();
            }
        });
    }
}
