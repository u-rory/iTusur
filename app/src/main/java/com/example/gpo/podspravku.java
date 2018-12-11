package com.example.gpo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class podspravku extends Fragment {
    private static final String PREFS_FILE = "Account";
    private static final String PREF_ITEM = "Item";
    private static final String PREF_FRAG = "Frag";
    SharedPreferences settings;
    private FragmentActivity myContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_podspravku, null);
        getActivity().setTitle("Справочник");
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "3");
        prefEditor.apply();
        ListView listView = (ListView) v.findViewById(R.id.listviewspravki);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager manager = myContext.getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                String number=String.valueOf(position);
                SharedPreferences.Editor prefEditor = settings.edit();
                prefEditor.putString(PREF_ITEM,number);
                prefEditor.apply();
                transaction.replace(R.id.content,new fragmenspravk()).commit();
            }
        });
        ArrayList<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        map = new HashMap<String, String>();
        map.put("Name", "Как встать на воинский учёт?");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Где взять справку об обучении?");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Время работы кассы ТУСУРа");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Адреса общежитий");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Адреса учебных корпусов");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Профсоюзная организация студентов");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Расписание занятий");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Как производится оплата");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Сроки выплаты стипендий");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Обучение за рубежом");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Групповое проектное обучение");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Программа «У.М.Н.И.К.»");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Материальное и социальное обеспечение");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Стажировки и содействие трудоустройству");
        myArrList.add(map);
        map = new HashMap<String, String>();
        map.put("Name", "Информационные ресурсы и сервисы");
        myArrList.add(map);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), myArrList, R.layout.rowspravka, new String[]{"Name"}, new int[]{R.id.textspravka});
        listView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}
