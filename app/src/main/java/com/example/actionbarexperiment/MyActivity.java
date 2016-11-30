package com.example.actionbarexperiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;

public class MyActivity extends AppCompatActivity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment breakfastFragment;
    private Fragment lunchFragment;
    private Fragment snackFragment;
    private Fragment dinnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // SET THE ACTIONBAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        // CREATE THE TABS AND BIND THEM TO THE ACTIONBAR

        ActionBar.Tab breakfastTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_breakfast));
        ActionBar.Tab lunchTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_lunch));
        ActionBar.Tab snackTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_snack));
        ActionBar.Tab dinnerTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_dinner));

        // CREATE EACH FRAGMENT AND BIND THEM TO THE ACTIONBAR
        breakfastFragment = new BreakfastFragment();
        snackFragment = new SnackFragment();
        lunchFragment = new LunchFragment();
        dinnerFragment = new DinnerFragment();

        // SET LISTENER EVENT FOR EACH OF THE ACTIONBAR TABS
        breakfastTab.setTabListener(new MyTabsListener(breakfastFragment,getApplicationContext()));
        snackTab.setTabListener(new MyTabsListener(snackFragment,getApplicationContext()));
        lunchTab.setTabListener(new MyTabsListener(lunchFragment,getApplicationContext()));
        dinnerTab.setTabListener(new MyTabsListener(dinnerFragment,getApplicationContext()));

        // ADD EACH OF THE TABS TO THE ACTIONBAR
        actionBar.addTab(breakfastTab);
        actionBar.addTab(lunchTab);
        actionBar.addTab(snackTab);
        actionBar.addTab(dinnerTab);

        //RESTORE NAVIGATION

        if (savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }

    }


    class MyTabsListener implements ActionBar.TabListener {
        public  Fragment fragment;

        public MyTabsListener(Fragment f, Context context) {
            fragment = f;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);

        }

        @Override
        public void onTabUnselected (ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/






}
