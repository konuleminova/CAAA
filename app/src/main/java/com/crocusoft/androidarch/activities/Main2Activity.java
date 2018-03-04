package com.crocusoft.androidarch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.events.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Main2Activity extends AppCompatActivity {
TextView testTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        testTextView=(TextView)findViewById(R.id.test_text);
        EventBus.getDefault().register(this);

    }
    @Subscribe
    public void onEvent(MessageEvent event){
        testTextView.setText(event.getMessage());

    }
}
