package com.example.actionbarexperiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;

public class MyActivity extends AppCompatActivity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment dessertFragment;
    private Fragment entreeFragment;
    private Fragment appetizerFragment;

    // old code
    //private Fragment snackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // SET THE ACTIONBAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        // CREATE THE TABS AND BIND THEM TO THE ACTIONBAR

        ActionBar.Tab dessertTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_dessert));
        ActionBar.Tab entreeTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_entree));
        ActionBar.Tab appetizerTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_appetizer));

        // old code
        //ActionBar.Tab snackTab = getSupportActionBar().newTab().setText(getString(R.string.ui_tabname_snack));

        // CREATE EACH FRAGMENT AND BIND THEM TO THE ACTIONBAR
        dessertFragment = new DessertFragment();
        entreeFragment = new EntreeFragment();
        appetizerFragment = new AppetizerFragment();

        //old code
        //snackFragment = new SnackFragment();

        // SET LISTENER EVENT FOR EACH OF THE ACTIONBAR TABS
        dessertTab.setTabListener(new MyTabsListener(dessertFragment,getApplicationContext()));
        //snackTab.setTabListener(new MyTabsListener(snackFragment,getApplicationContext()));
        entreeTab.setTabListener(new MyTabsListener(entreeFragment,getApplicationContext()));
        appetizerTab.setTabListener(new MyTabsListener(appetizerFragment,getApplicationContext()));

        // ADD EACH OF THE TABS TO THE ACTIONBAR

        actionBar.addTab(appetizerTab);
        actionBar.addTab(entreeTab);
        actionBar.addTab(dessertTab);

        // old code
        // actionBar.addTab(snackTab);


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
