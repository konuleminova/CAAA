package com.crocusoft.androidarch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crocusoft.androidarch.R;

import static com.crocusoft.androidarch.utility.Constants.KEY_ID;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_CONTENT;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_NAME;

/**
 * Created by Asus on 2/23/2018.
 */

public class ItemContentFragment extends Fragment {
    TextView itemId_textView, itemName_textView, itemSurname_textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_content_layout, container, false);
        itemId_textView = (TextView) view.findViewById(R.id.item_id);
        itemName_textView = (TextView) view.findViewById(R.id.item_name);
        itemSurname_textView = (TextView) view.findViewById(R.id.item_surname);
        Bundle bundle = this.getArguments();
        itemId_textView.setText(bundle.getString(KEY_ID));
        itemName_textView.setText(bundle.getString(KEY_ITEM_NAME));
        itemSurname_textView.setText(bundle.getString(KEY_ITEM_CONTENT));
        return view;
    }

}
