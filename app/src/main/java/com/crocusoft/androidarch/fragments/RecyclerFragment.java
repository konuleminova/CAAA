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
import com.crocusoft.androidarch.recyclerview.RecyclerAdapter;
import com.crocusoft.androidarch.recyclerview.RecyclerObjects;
import com.crocusoft.androidarch.recyclerview.RecycleItemClcikListener;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static com.crocusoft.androidarch.utilities.Constants.KEY_ITEM_NAME;
import static com.crocusoft.androidarch.utilities.Constants.TAG_FRAGMENT;

/**
 * Created by Asus on 2/20/2018.
 */

public class RecyclerFragment extends Fragment {

    private List<RecyclerObjects> recyclerObjects;
    private RecyclerView recyclerView;
    SetFragmentInterface setFragmentInterface;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyler_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerObjects = new ArrayList<>();
        recyclerObjects.add(new RecyclerObjects("recycler view text1", R.drawable.place));
        recyclerObjects.add(new RecyclerObjects("recycler view tex2", R.drawable.place));
        recyclerObjects.add(new RecyclerObjects("recycler view text3", R.drawable.place));
        recyclerObjects.add(new RecyclerObjects("recycler view tex4", R.drawable.place));
        recyclerObjects.add(new RecyclerObjects("recycler view text5", R.drawable.place));
        recyclerObjects.add(new RecyclerObjects("recycler view tex6", R.drawable.place));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerObjects, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.addOnItemTouchListener(
                new RecycleItemClcikListener(getContext(), new RecycleItemClcikListener.ItemClickListner() {
                    @Override
                    public void clickEvent(View v, int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_ITEM_NAME, recyclerObjects.get(position).getItemName());
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
