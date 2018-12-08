package com.example.gpo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentTabHost;

import com.example.gpo.db.DatabaseHandler;

import java.util.Calendar;
import java.util.Date;

public class timetable extends Fragment {
   private FragmentTabHost mTabHost;
    int week;
    private static final String PREFS_FILE = "Account";
    private static final String PREF_FRAG = "Frag";
    SharedPreferences settings;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Расписание");
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "1");
        prefEditor.apply();
        DatabaseHandler db = new DatabaseHandler(getContext());
        int count=db.getDaysCount();
        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_timetable);
        Bundle arg1 = new Bundle();
        mTabHost.getTabWidget().setBackground(new ColorDrawable(Color.parseColor("#114791")));
        mTabHost.addTab(mTabHost.newTabSpec("Tab1").setIndicator("Четная"), test.class, arg1);
        Bundle arg2 = new Bundle();
        mTabHost.addTab(mTabHost.newTabSpec("Tab2").setIndicator("Нечетная"), test2.class, arg2);
        if(count>0) {
            Date date = new Date();
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(date);
            int Date = currentCalendar.get(Calendar.DAY_OF_MONTH);
            int Month = currentCalendar.get(Calendar.MONTH);
            int Year = currentCalendar.get(Calendar.YEAR);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, Date);
            calendar.set(Calendar.YEAR, Year);
            calendar.add(Calendar.MONTH, Month + 1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            calendar2.set(Calendar.DAY_OF_MONTH, 30);
            calendar2.set(Calendar.YEAR, 2010);
            calendar2.add(Calendar.MONTH, 8);
            long diff = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            week = (int) (days / 7) + 1;
            if (week % 2 != 0) {mTabHost.setCurrentTabByTag("Tab1");
            } else {mTabHost.setCurrentTabByTag("Tab2");}
        }
        else
        {
            CustomDialogFrament dialog = new CustomDialogFrament();
            dialog.show(getFragmentManager(), "custom");
        }
        return mTabHost;
    }
    @Override
    public void onDestroyView() {super.onDestroyView();mTabHost = null;}
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {inflater.inflate(R.menu.popup, menu);super.onCreateOptionsMenu(menu, inflater);}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, new podgruzon()).commit();
                return true;
            case R.id.kek2:
                CustomDialogFrament dialog = new CustomDialogFrament();
                dialog.show(getFragmentManager(), "custom");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
