package com.crocusoft.androidarch.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.crocusoft.androidarch.R;
import com.crocusoft.androidarch.fragments.EventBusFragment;
import com.crocusoft.androidarch.fragments.ListFragment;
import com.crocusoft.androidarch.fragments.RecyclerFragment;
import com.crocusoft.androidarch.fragments.SendBroadcastFragment;
import com.crocusoft.androidarch.interfaces.SetFragmentInterface;
import com.crocusoft.androidarch.fragments.TabFfragment;
import com.crocusoft.androidarch.interfaces.FragmentDataPassInterface;

import static com.crocusoft.androidarch.utility.Constants.TAG_FRAGMENT;

public class MainActivity extends AppCompatActivity implements SetFragmentInterface ,FragmentDataPassInterface {
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView navHeaderText;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        setNavigationView();
        RecyclerFragment recyclerFragment = new RecyclerFragment();
        setFragment(null, recyclerFragment);
        View header = navigationView.getHeaderView(0);
        navHeaderText = (TextView) header.findViewById(R.id.nav_header_email_text);
        navHeaderText.setText("nav");

        // org.greenrobot.eventbus.EventBus.getDefault().register(this);

    }

    /* @Subscribe
     public void onEvent(MessageEvent eventBus){
         navHeaderText.setText(eventBus.getMessage());
     }
     */
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
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
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
                        break;
                    case R.id.broadCast:
                        SendBroadcastFragment broadcast = new SendBroadcastFragment();
                        setFragment(TAG_FRAGMENT, broadcast);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.eventBus:
                        EventBusFragment eventBusFragment = new EventBusFragment();
                        setFragment(TAG_FRAGMENT, eventBusFragment);
                        drawerLayout.closeDrawers();
                        break;

                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {

            Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT);
            if (fragment != null) {
                getSupportFragmentManager().popBackStackImmediate();
            } else {
                finish();
            }
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

    @Override
    public void setMessage(String message) {
        navHeaderText.setText(message);
    }
}
