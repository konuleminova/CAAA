package com.crocusoft.androidarch.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.adapters.ListAdapter;
import com.crocusoft.androidarch.interfaces.SetFragmentInterface;
import com.crocusoft.androidarch.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.crocusoft.androidarch.utility.Constants.KEY_ID;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_CONTENT;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_NAME;
import static com.crocusoft.androidarch.utility.Constants.TAG_FRAGMENT;

/**
 * Created by Asus on 2/22/2018.
 */

public class ListFragment extends Fragment {

    private List<User> listObjects;
    private ListView listView;
    SetFragmentInterface setFragmentInterface;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_layout, container, false);
        listView = view.findViewById(R.id.list_view);
        listObjects = new ArrayList<>();
        listObjects.add(new User("1","Name", "Surname", R.drawable.user));
        listObjects.add(new User("2","Name", "Surname", R.drawable.user));
        listObjects.add(new User("3","Name", "Surname", R.drawable.user));
        listObjects.add(new User("4","Name", "Surname", R.drawable.user));
        listObjects.add(new User("5","Name", "Surname", R.drawable.user));
        listObjects.add(new User("6","Name", "Surname", R.drawable.user));
        final ListAdapter listAdapter = new ListAdapter(getActivity(), listObjects);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("itemlist", listObjects.get(i).toString());
                Bundle bundle = new Bundle();
                bundle.putString(KEY_ID,listObjects.get(i).getUserId().toString());
                bundle.putString(KEY_ITEM_NAME, listObjects.get(i).getName().toString());
                bundle.putString(KEY_ITEM_CONTENT, listObjects.get(i).getSurname().toString());
                ItemContentFragment fragment = new ItemContentFragment();
                setFragmentInterface.setFragment(TAG_FRAGMENT, fragment);
                fragment.setArguments(bundle);

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            setFragmentInterface = (SetFragmentInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnFragmentInteractionListener");
        }
    }
}
