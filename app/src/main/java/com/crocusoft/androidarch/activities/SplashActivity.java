package com.crocusoft.androidarch.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.utility.SharedPreferenceUtils;

import static com.crocusoft.androidarch.utility.Constants.DEFAULT_VALUE;
import static com.crocusoft.androidarch.utility.Constants.KEY_TOKEN;
import static com.crocusoft.androidarch.utility.Constants.SPLASH_TIME_OUT;

public class SplashActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferenceUtils utils = new SharedPreferenceUtils(SplashActivity.this);
                String token = utils.getStringData(KEY_TOKEN, DEFAULT_VALUE);
                if (token.equals(DEFAULT_VALUE)) {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);



    }
}
