package com.crocusoft.androidarch.tabview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.crocusoft.androidarch.fragments.ListFragment;
import com.crocusoft.androidarch.fragments.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2/23/2018.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentName = new ArrayList<>();

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void add(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentName.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentName.get(position);
    }
}
