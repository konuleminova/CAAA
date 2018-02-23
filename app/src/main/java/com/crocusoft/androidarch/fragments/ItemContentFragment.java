package com.crocusoft.androidarch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crocusoft.androidarch.R;

import static com.crocusoft.androidarch.utilities.Constants.KEY_ITEM_CONTENT;
import static com.crocusoft.androidarch.utilities.Constants.KEY_ITEM_NAME;

/**
 * Created by Asus on 2/23/2018.
 */

public class ItemContentFragment extends Fragment {
    TextView itemName_textView;
    TextView itemContent_TextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_content_layout, container, false);
        itemName_textView = (TextView) view.findViewById(R.id.item_name);
        itemContent_TextView = (TextView) view.findViewById(R.id.item_content);
        Bundle bundle = this.getArguments();
        itemName_textView.setText(bundle.getString(KEY_ITEM_NAME));
        itemContent_TextView.setText(bundle.getString(KEY_ITEM_CONTENT));
        return view;
    }

}
