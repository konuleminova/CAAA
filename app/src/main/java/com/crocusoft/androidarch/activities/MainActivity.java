package com.crocusoft.androidarch.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.fragments.ListFragment;
import com.crocusoft.androidarch.fragments.RecyclerFragment;
import com.crocusoft.androidarch.fragments.SetFragment;
import com.crocusoft.androidarch.fragments.TabFfragment;

import static com.crocusoft.androidarch.utilities.Constants.TAG_FRAGMENT;
import static com.crocusoft.androidarch.utilities.Constants.TAG_FRAGMENT_INSIDE;

public class MainActivity extends AppCompatActivity implements SetFragment {
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setNavigationView();
        RecyclerFragment recyclerFragment = new RecyclerFragment();
        setFragment(null, recyclerFragment);

    }

    public void setUpToolBar() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    public void setNavigationView() {
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.recyclerView:
                        RecyclerFragment recyclerFragment = new RecyclerFragment();
                        setFragment(null, recyclerFragment);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.listView:
                        ListFragment listFragment = new ListFragment();
                        setFragment(TAG_FRAGMENT, listFragment);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.tabView:
                        TabFfragment tabFfragment = new TabFfragment();
                        setFragment(TAG_FRAGMENT, tabFfragment);
                        drawerLayout.closeDrawers();
                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
       Fragment fragment=getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);
       if(fragment!=null) {
           getSupportFragmentManager().popBackStackImmediate();
       }
       else {
           finish();
       }

    }

    @Override
    public void setFragment(String backstackTAG, Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment, backstackTAG);
        fragmentTransaction.addToBackStack(backstackTAG);
        fragmentTransaction.commit();
    }
}
