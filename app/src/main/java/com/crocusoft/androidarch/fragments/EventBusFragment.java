package com.crocusoft.androidarch.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.events.MessageEvent;
import com.crocusoft.androidarch.interfaces.FragmentDataPassInterface;

/**
 * Created by Asus on 3/2/2018.
 */

public class EventBusFragment extends Fragment {

    EditText messageText;
    Button btnOk;
    FragmentDataPassInterface fragmentDataPassInterface;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        fragmentDataPassInterface = (FragmentDataPassInterface) context;

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_bus, container, false);
        messageText = (EditText) view.findViewById(R.id.editText_email_address);
        btnOk = (Button) view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageText.getText().toString();
                fragmentDataPassInterface.setMessage(message);
                MessageEvent eventBus = new MessageEvent();
                eventBus.setMessage(message);
                org.greenrobot.eventbus.EventBus.getDefault().post(eventBus);

            }
        });
        return view;
    }
}
