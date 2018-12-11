package com.example.gpo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class navigate extends AppCompatActivity {
    private static final String PREFS_FILE = "Account";
    private static final String PREF_FRAG = "Frag";
    private TextView mTextMessage;
    SharedPreferences settings;
    int numberfrag;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content, new podnews()).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_timetable:
                    transaction.replace(R.id.content, new timetable()).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_maps:
                    transaction.replace(R.id.content, new Maps2()).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_spravka:
                    transaction.replace(R.id.content, new podspravku()).commitAllowingStateLoss();
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_navigate);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, new timetable()).commitAllowingStateLoss();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_timetable);
        DlyaNavigate.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                   onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        String podnumber=settings.getString(PREF_FRAG,"0");
        numberfrag = Integer.parseInt(podnumber);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(numberfrag==0) {
            finish();
        }
        if(numberfrag==1) {
            navigation.setSelectedItemId(R.id.navigation_home);
            transaction.replace(R.id.content, new podnews()).commitAllowingStateLoss();
        }
        if(numberfrag==2) {
            navigation.setSelectedItemId(R.id.navigation_home);
            transaction.replace(R.id.content, new podnews()).commitAllowingStateLoss();
        }
        if(numberfrag==3) {
            navigation.setSelectedItemId(R.id.navigation_home);
            transaction.replace(R.id.content, new podnews()).commitAllowingStateLoss();
        }
        if(numberfrag==4) {
            navigation.setSelectedItemId(R.id.navigation_home);
            transaction.replace(R.id.content, new podnews()).commitAllowingStateLoss();
        }
        if(numberfrag==5) {
            navigation.setSelectedItemId(R.id.navigation_spravka);
            transaction.replace(R.id.content, new podspravku()).commitAllowingStateLoss();
        }
        if(numberfrag==6) {
            navigation.setSelectedItemId(R.id.navigation_maps);
            transaction.replace(R.id.content, new Maps2()).commitAllowingStateLoss();
        }
    }
}
