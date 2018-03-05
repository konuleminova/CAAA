package com.crocusoft.androidarch.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.adapters.RecyclerAdapter;
import com.crocusoft.androidarch.interfaces.SetFragmentInterface;
import com.crocusoft.androidarch.model.User;
import com.crocusoft.androidarch.utility.RecycleItemClcikListener;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static com.crocusoft.androidarch.utility.Constants.KEY_ID;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_CONTENT;
import static com.crocusoft.androidarch.utility.Constants.KEY_ITEM_NAME;
import static com.crocusoft.androidarch.utility.Constants.TAG_FRAGMENT;

/**
 * Created by Asus on 2/20/2018.
 */

public class RecyclerFragment extends Fragment {

    private List<User> recyclerObjects;
    private RecyclerView recyclerView;
    SetFragmentInterface setFragmentInterface;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyler_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerObjects = new ArrayList<>();
        recyclerObjects.add(new User("1", "Name", "Surname", R.drawable.place));
        recyclerObjects.add(new User("2", "Name", "Surname", R.drawable.place));
        recyclerObjects.add(new User("3", "Name", "Surname", R.drawable.place));
        recyclerObjects.add(new User("4", "Name", "Surname", R.drawable.place));
        recyclerObjects.add(new User("5", "Name", "Surname", R.drawable.place));
        recyclerObjects.add(new User("6", "Name", "Surname", R.drawable.place));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerObjects, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addOnItemTouchListener(
                new RecycleItemClcikListener(getContext(), new RecycleItemClcikListener.ItemClickListner() {
                    @Override
                    public void clickEvent(View v, int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_ITEM_NAME, recyclerObjects.get(position).getUserName());
                        bundle.putString(KEY_ID, recyclerObjects.get(position).getUserId());
                        bundle.putString(KEY_ITEM_CONTENT, recyclerObjects.get(position).getUserSurname());
                        ItemContentFragment itemContentFragment = new ItemContentFragment();
                        setFragmentInterface.setFragment(TAG_FRAGMENT, itemContentFragment);
                        itemContentFragment.setArguments(bundle);
                    }
                }
                ));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        setFragmentInterface = (SetFragmentInterface) context;
    }
}
