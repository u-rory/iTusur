package com.example.gpo;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gpo.Data.DataModel;
import com.example.gpo.Data.NEWSS;
import com.example.gpo.db.DatabaseHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class podnews extends Fragment {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    View rootview;
    private static final String PREFS_FILE = "Account";
    private static final String PREF_NEWS = "news";
    private static final String PREF_FRAG = "Frag";
    SharedPreferences settings;
    SwipeRefreshLayout mSwipeRefreshLayout;
    DatabaseHandler db;
    TextView textView;
    static View.OnClickListener myOnClickListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Новости");
        db = new DatabaseHandler(getContext());
        rootview = inflater.inflate(R.layout.fragment_podnews, container, false);
        return rootview;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "0");
        prefEditor.apply();
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootview.findViewById(R.id.swipe_container);
        myOnClickListener = new MyOnClickListener(getActivity());//
        recyclerView = (RecyclerView) rootview.findViewById(R.id.my_recycler_view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        textView = (TextView)view.findViewById(R.id.textViewpodnews2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        data = new ArrayList<>();
        adapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(adapter);
        List<NEWSS> contacts = db.getAllNews();
        int count = db.getNewsCount();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(isOnline()) {new ParseTitle2().execute();}
                else {
                    Toast.makeText(getActivity(), "Connection problem", Toast.LENGTH_SHORT).show();
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        if(count>0) {
            for (NEWSS cn : contacts) {data.add(new DataModel(cn.getText(), cn.getDate(),cn.getName(),cn.getImages()));}
            adapter.notifyDataSetChanged();
        }
        else
        {
            if(isOnline()) {
                mSwipeRefreshLayout.setRefreshing(true);
                new ParseTitle2().execute();
            }
            else {textView.setVisibility(View.VISIBLE);}
        }
    }
    public static class MyOnClickListener implements View.OnClickListener {
        private final Context context;
        private MyOnClickListener(Context context) {
            this.context = context;
        }
        @Override
        public void onClick(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            SharedPreferences settings = ((FragmentActivity)context).getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor prefEditor = settings.edit();
            prefEditor.putString(PREF_NEWS, Integer.toString(selectedItemPosition));
            prefEditor.apply();
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.content, new TryNews()).commit();
        }
    }
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    public class ParseTitle2 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... arg) {
            db.deleteAllNews();
            String[][] text = new String[10][5];
            try {
                Document document = Jsoup.connect("https://tusur.ru/ru/novosti-i-meropriyatiya/novosti?page=1").get();
                Elements elements = document.select(".news-page-list-item>.news-page-list-item-annotation");
                Elements elements2 = document.select(".news-page-list-item-since");
                Elements elements3 = document.select(".news-page-list-item-img");
                Elements elements4 = document.select(".news-page-list-item>h1>a");
                Elements elements5 = document.select(".news-page-list-item-img > a > img");
                int a = 0;
                for (Element element : elements) {
                    if(a<10) {
                        text[a][0] = element.text();
                        a++;
                    } else {break;}}
                a = 0;
                for (Element az : elements2) {
                    if(a<10) {
                        text[a][1] = az.text();
                        a++;
                    } else {break;}}
                a = 0;
                for (Element podlink : elements3) {
                    if(a<10) {
                        Element link = podlink.select("a").first();
                        text[a][2] = link.attr("abs:href");
                        a++;
                    } else {break;}}
                a=0;
                for (Element az : elements4) {
                    if(a<10) {
                        text[a][3] = az.text();
                        a++;
                    } else {break;}}
                a=0;
                for (Element img : elements5)  {
                    if(a<10) {
                        Element myImage = img;
                        text[a][4] = myImage.attr("src");
                        a++;
                    } else {break;}}

                for(int i=0;i<10;i++) {
                    db.addNews(new NEWSS( text[i][0], text[i][1],  text[i][2],  text[i][3] , text[i][4]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setVisibility(View.INVISIBLE);
            List<NEWSS> contacts = db.getAllNews();
            for (NEWSS cn : contacts) {data.add(new DataModel(cn.getText(), cn.getDate(),cn.getName(),cn.getImages()));}
            mSwipeRefreshLayout.setRefreshing(false);
            adapter = new RecyclerAdapter(data);
            //adapter.notifyDataSetChanged();
           // recyclerView.invalidate();
            Toast.makeText(getActivity(), "Обновлено", Toast.LENGTH_SHORT).show();
        }
    }
}
