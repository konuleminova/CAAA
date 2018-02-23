package com.crocusoft.androidarch.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    int id;
    RecyclerFragment recyclerFragment;
    ListFragment listFragment;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String TAG_FRAGMENT = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setNavigationView();
    }

    public void setFragment(android.support.v4.app.Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment, TAG_FRAGMENT);
        fragmentTransaction.addToBackStack(TAG_FRAGMENT);
        fragmentTransaction.commit();
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
                id = item.getItemId();
                switch (id) {
                    case R.id.recyclerView:
                        recyclerFragment = new RecyclerFragment();
                        setFragment(recyclerFragment);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.listView:
                        listFragment = new ListFragment();
                        setFragment(listFragment);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        android.support.v4.app.Fragment fragment = fragmentManager.findFragmentByTag(TAG_FRAGMENT);
        fragmentManager.beginTransaction().remove(fragment).commit();
    }

}
