package com.example.gpo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test extends Fragment {
    static final int PAGE_COUNT = 6;
    ViewPager pager;
    PagerAdapter pagerAdapter;
    View rootView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        pager = (ViewPager) view.findViewById(R.id.pager);
        pagerAdapter = new test.MyFragmentPagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);
        Date date = new Date();
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(date);
        int  Date = currentCalendar.get(Calendar.DAY_OF_MONTH);
        int  Month = currentCalendar.get(Calendar.MONTH);
        int  Year = currentCalendar.get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, Date);
        calendar.set(Calendar.YEAR, Year);
        calendar.add(Calendar.MONTH, Month+1);
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
        int week = (int)(days/7) + 1;
        if (week%2!=0) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        if(dayOfTheWeek.equals("понедельник")) {pager.setCurrentItem(0);}
        if(dayOfTheWeek.equals("вторник")) {pager.setCurrentItem(1);}
        if(dayOfTheWeek.equals("среда")) {pager.setCurrentItem(2);}
        if(dayOfTheWeek.equals("четверг")) {pager.setCurrentItem(3);}
        if(dayOfTheWeek.equals("пятница")) {pager.setCurrentItem(4);}
        if(dayOfTheWeek.equals("суббота")) {pager.setCurrentItem(5);};}
    }
    private class MyFragmentPagerAdapter extends FragmentPagerAdapter  {
        public MyFragmentPagerAdapter(FragmentManager fm) {super(fm);}
        @Override
        public CharSequence getPageTitle(int position) {
            String week="";
            if(position==0) {week="Понедельник";}
            if(position==1) {week="Вторник";}
            if(position==2) {week="Среда";}
            if(position==3) {week="Четверг";}
            if(position==4) {week="Пятница";}
            if(position==5) {week="Суббота";}
            return week;
        }
       @Override
        public Fragment getItem(int position) {return fragmentforviewpager.newInstance(position);}
        @Override
        public int getCount() {return PAGE_COUNT;}
    }
}

