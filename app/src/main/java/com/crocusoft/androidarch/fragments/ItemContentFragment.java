package com.crocusoft.androidarch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crocusoft.androidarch.R;

import static com.crocusoft.androidarch.utility.Constants.KEY_ID;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_CONTENT;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_NAME;

/**
 * Created by Asus on 2/23/2018.
 */

public class ItemContentFragment extends Fragment {
    TextView itemIdTextView, itemNameTextView, itemSurnameTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_content_layout, container, false);
        itemIdTextView = (TextView) view.findViewById(R.id.item_id);
        itemNameTextView = (TextView) view.findViewById(R.id.item_name);
        itemSurnameTextView = (TextView) view.findViewById(R.id.item_surname);
        Bundle bundle = this.getArguments();
        itemIdTextView.setText(bundle.getString(KEY_ID));
        itemNameTextView.setText(bundle.getString(KEY_ITEM_NAME));
        itemSurnameTextView.setText(bundle.getString(KEY_ITEM_CONTENT));
        return view;
    }

}
