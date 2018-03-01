package com.crocusoft.androidarch.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.crocusoft.androidarch.R;

/**
 * Created by Asus on 3/1/2018.
 */

public class SendBroadcast extends Fragment {
    Button setBroadcast;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.broadcast_reciever,container,false);
        setBroadcast =(Button)view.findViewById(R.id.send_broadcast);
        setBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setAction("com.crocusoft.androidarch.SEND_NOTIFICATION");
                getActivity().sendBroadcast(intent);

            }
        });

        return view;
    }
}
