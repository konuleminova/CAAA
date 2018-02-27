package com.crocusoft.androidarch.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.listview.ListObjects;
import com.crocusoft.androidarch.tabview.TabsPagerAdapter;

/**
 * Created by Asus on 2/23/2018.
 */

public class TabFfragment extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_tab_layout, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        TabsPagerAdapter adapter = new TabsPagerAdapter(this.getChildFragmentManager());
        adapter.add(new RecyclerFragment(),"Recycler View");
        adapter.add(new ListFragment(),"List View");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
