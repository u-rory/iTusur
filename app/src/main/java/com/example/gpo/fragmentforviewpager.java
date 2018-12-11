package com.example.gpo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gpo.Data.DataAdapter;
import com.example.gpo.Data.Day;
import com.example.gpo.Data.Phone;
import com.example.gpo.db.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;

public class fragmentforviewpager extends Fragment {
    public Elements content;
    List<Phone> phones = new ArrayList<>();
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String SAVE_PAGE_NUMBER = "save_page_number";
    int pageNumber;
    DataAdapter adapter;
    View view;
    static fragmentforviewpager newInstance(int page) {
        fragmentforviewpager pageFragment = new fragmentforviewpager();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        int savedPageNumber = 0;
        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragmentforviewpager, null);
        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Day> contacts = db.getAllDay();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list2);
        if (pageNumber == 0) {phones.clear();
            int a = 0, c = 0, n = 0;
            for (Day cn : contacts) {a++;
                if (a < 8) {c++;
                    if (!cn.getPredmet().contains("Нет занятий")){
                        if (c == 1) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "8:50 - 10:20"));}
                        if (c == 2) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "10:40 - 12:15"));}
                        if (c == 3) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "13:15 - 14:50"));}
                        if (c == 4) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "15:00 - 16:35"));}
                        if (c == 5) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "16:45 - 18:20"));}
                        if (c == 6) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "18:30 - 20:05"));}
                        if (c == 7) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "20:15 - 21:50"));}
                        n++;}
                    if (n > 0) {
                        TextView textView = (TextView) view.findViewById(R.id.textViewpodraspis);
                        textView.setVisibility(View.GONE);
                    }
                    else {recyclerView.setVisibility(View.VISIBLE);}
                }
            }
        }
        if (pageNumber == 1) {phones.clear();
            int a = 0, c = 0, n = 0;
            for (Day cn : contacts) {a++;
                if (a > 7 && a < 15) {c++;
                    if (!cn.getPredmet().contains("Нет занятий")){
                        if (c == 1) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "8:50 - 10:20"));}
                        if (c == 2) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "10:40 - 12:15"));}
                        if (c == 3) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "13:15 - 14:50"));}
                        if (c == 4) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "15:00 - 16:35"));}
                        if (c == 5) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "16:45 - 18:20"));}
                        if (c == 6) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "18:30 - 20:05"));}
                        if (c == 7) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "20:15 - 21:50"));}
                        n++;}
                    if (n > 0) {
                        TextView textView = (TextView) view.findViewById(R.id.textViewpodraspis);
                        textView.setVisibility(View.GONE);
                    }
                    else {recyclerView.setVisibility(View.VISIBLE);}
                }
            }
        }
        if (pageNumber == 2) {phones.clear();
            int a = 0, c = 0, n = 0;
            for (Day cn : contacts) {a++;
                if (a > 14 && a < 22) {c++;
                    if (!cn.getPredmet().contains("Нет занятий")){
                        if (c == 1) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "8:50 - 10:20"));}
                        if (c == 2) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "10:40 - 12:15"));}
                        if (c == 3) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "13:15 - 14:50"));}
                        if (c == 4) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "15:00 - 16:35"));}
                        if (c == 5) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "16:45 - 18:20"));}
                        if (c == 6) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "18:30 - 20:05"));}
                        if (c == 7) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "20:15 - 21:50"));}
                        n++;}
                    if (n > 0) {
                        TextView textView = (TextView) view.findViewById(R.id.textViewpodraspis);
                        textView.setVisibility(View.GONE);
                    }
                    else {recyclerView.setVisibility(View.VISIBLE);}
                }
            }
        }
        if (pageNumber == 3) {phones.clear();
            int a = 0, c = 0, n = 0;
            for (Day cn : contacts) {a++;
                if (a > 21 && a < 29) {c++;
                    if (!cn.getPredmet().contains("Нет занятий")){
                        if (c == 1) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "8:50 - 10:20"));}
                        if (c == 2) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "10:40 - 12:15"));}
                        if (c == 3) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "13:15 - 14:50"));}
                        if (c == 4) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "15:00 - 16:35"));}
                        if (c == 5) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "16:45 - 18:20"));}
                        if (c == 6) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "18:30 - 20:05"));}
                        if (c == 7) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "20:15 - 21:50"));}
                        n++;}
                    if (n > 0) {
                        TextView textView = (TextView) view.findViewById(R.id.textViewpodraspis);
                        textView.setVisibility(View.GONE);
                    }
                    else {recyclerView.setVisibility(View.VISIBLE);}
                }
            }
        }
        if (pageNumber == 4) {phones.clear();
            int a = 0, c = 0, n = 0;
            for (Day cn : contacts) {a++;
                if (a > 28 && a < 36) {c++;
                    if (!cn.getPredmet().contains("Нет занятий")){
                        if (c == 1) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "8:50 - 10:20"));}
                        if (c == 2) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "10:40 - 12:15"));}
                        if (c == 3) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "13:15 - 14:50"));}
                        if (c == 4) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "15:00 - 16:35"));}
                        if (c == 5) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "16:45 - 18:20"));}
                        if (c == 6) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "18:30 - 20:05"));}
                        if (c == 7) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "20:15 - 21:50"));}
                        n++;}
                    if (n > 0) {
                        TextView textView = (TextView) view.findViewById(R.id.textViewpodraspis);
                        textView.setVisibility(View.GONE);
                    }
                    else {recyclerView.setVisibility(View.VISIBLE);}
                }
            }
        }
        if (pageNumber == 5) {phones.clear();
            int a = 0, c = 0, n = 0;
            for (Day cn : contacts) {a++;
                if (a > 35 && a < 43) {c++;
                    if (!cn.getPredmet().contains("Нет занятий")){
                        if (c == 1) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "8:50 - 10:20"));}
                        if (c == 2) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "10:40 - 12:15"));}
                        if (c == 3) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "13:15 - 14:50"));}
                        if (c == 4) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "15:00 - 16:35"));}
                        if (c == 5) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "16:45 - 18:20"));}
                        if (c == 6) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "18:30 - 20:05"));}
                        if (c == 7) {phones.add(new Phone(cn.getPredmet(), cn.getType(), cn.getAud(), cn.getPrepod(), "20:15 - 21:50"));}
                        n++;}
                    if (n > 0) {
                        TextView textView = (TextView) view.findViewById(R.id.textViewpodraspis);
                        textView.setVisibility(View.GONE);
                    }
                    else {recyclerView.setVisibility(View.VISIBLE);}
                }
            }
        }
        adapter = new DataAdapter(getActivity(), phones);
        recyclerView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
