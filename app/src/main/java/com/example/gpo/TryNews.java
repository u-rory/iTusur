package com.example.gpo;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gpo.Data.NEWSS;
import com.example.gpo.db.DatabaseHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.List;

public class TryNews extends Fragment {
    private static final String PREFS_FILE = "Account";
    private static final String PREF_NEWS = "news";
    private static final String PREF_FRAG = "Frag";
    WebView webview;
    int numbernews;
    ProgressBar pb;
    SharedPreferences settings;
    String htmllol="<html><head></head><body><div style=\"width:134%\">";
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_try_news, null);
        pb = (ProgressBar) view.findViewById(R.id.progressBar3);
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "4");
        prefEditor.apply();
        if(isOnline()) {
            pb.setVisibility(ProgressBar.VISIBLE);
            numbernews = Integer.parseInt(settings.getString(PREF_NEWS,""));
            webview=(WebView) view.findViewById(R.id.asdasdasd);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setDefaultFontSize(120);
            webview.getSettings().setUseWideViewPort(true);
            webview.getSettings().setLoadWithOverviewMode(true);
            webview.setWebViewClient(new MyWebViewClient());
            TryNews.ParseTitle parseTitle = new TryNews.ParseTitle();
            parseTitle.execute();
        }
        else
        {
            Toast.makeText(getActivity(), "Connection problem", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content, new podnews()).commit();
        }
        return view;
    }

    public class ParseTitle extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... arg) {
            DatabaseHandler db = new DatabaseHandler(getContext());
            try {
                List<NEWSS> contacts = db.getAllNews();
                int a = -1;
                for (NEWSS cn : contacts) {
                    a++;
                    if (a == numbernews) {
                        Document doc = Jsoup.connect(cn.getLink()).get();
                        if (doc != null) {
                            Elements elements = doc.select(" div.news-item > div.row");
                            Elements elements2 = doc.select("div.content.index > h1");
                            htmllol = htmllol + "<strong>" + elements2.html() + "</strong>";
                            htmllol = htmllol + elements.html();
                            htmllol = htmllol + "</div></body></html>";
                        } else {
                            Toast.makeText(getActivity(), "Connection problem", Toast.LENGTH_SHORT).show();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.replace(R.id.content, new podnews()).commit();
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            webview.loadData(htmllol, "text/html", null);
        }
    }
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pb.setVisibility(ProgressBar.INVISIBLE);
        }
    }
}