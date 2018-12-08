package com.example.gpo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gpo.Data.DataMaps;

import java.util.ArrayList;


public class Maps2 extends Fragment {
    SharedPreferences settings;
    private static ArrayList<DataMaps> data;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    View v;
    private static final String PREFS_FILE = "Account";
    private static final String PREF_FRAG = "Frag";
    private static final String PREF_ROOMS = "Rooms";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Карты");
        v = inflater.inflate(R.layout.fragment_maps2, null);;
        return v;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "2");
        prefEditor.putString(PREF_ROOMS, "0");
        prefEditor.apply();
        myOnClickListener = new Maps2.MyOnClickListener(getActivity());//
        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_viewmaps);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setVisibility(View.VISIBLE);
        data = new ArrayList<DataMaps>();
        data.add(new DataMaps("ГК", "Учебный корпус",R.drawable.gk));
        data.add(new DataMaps("УЛК", "Учебный корпус",R.drawable.ulk));
        data.add(new DataMaps("ФЭТ", "Учебный корпус",R.drawable.fet));
        data.add(new DataMaps("РК", "Учебный корпус",R.drawable.rk));
        data.add(new DataMaps("«Дружба»", "Студенческий бизнес-инкубатор",R.drawable.friend));
        adapter = new RecyclerAdapterMaps(data);
        recyclerView.setAdapter(adapter);
    }
    public  class MyOnClickListener implements View.OnClickListener {
        private final Context context;
        private MyOnClickListener(Context context) {
            this.context = context;
        }
        @Override
        public void onClick(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            Intent i = new Intent(getActivity(), FORMAPS.class);
            getActivity().startActivity(i);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_ROOMS, "0");
        prefEditor.apply();
    }
}