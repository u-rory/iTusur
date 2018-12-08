package com.example.gpo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class fragmenspravk extends Fragment {
    private static final String PREFS_FILE = "Account";
    private static final String PREF_ITEM = "Item";
    private static final String PREF_FRAG = "Frag";
    SharedPreferences settings;
    private WebView webView;
    ProgressBar pb;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fragmenspravk, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        pb = (ProgressBar) view.findViewById(R.id.progressBar4);
        pb.setVisibility(ProgressBar.VISIBLE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_FRAG, "5");
        prefEditor.apply();
        webView = (WebView) view.findViewById(R.id.webview);
        webView.setWebViewClient(new fragmenspravk.MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setTextZoom(300);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        String name = settings.getString(PREF_ITEM,"0");
        int foo= Integer.parseInt(name);
        switch (foo) {
            case 0:
                webView.loadUrl("file:///android_asset/0.html");
                break;
            case 1:
                webView.loadUrl("file:///android_asset/1.html");
                break;
            case 2:
                webView.loadUrl("file:///android_asset/2.html");
                break;
            case 3:
                webView.loadUrl("file:///android_asset/3.html");
                break;
            case 4:
                webView.loadUrl("file:///android_asset/4.html");
                break;
            case 5:
                webView.loadUrl("file:///android_asset/5.html");
                break;
            case 6:
                webView.loadUrl("file:///android_asset/6.html");
                break;
            case 7:
                webView.loadUrl("file:///android_asset/7.html");
                break;
            case 8:
                webView.loadUrl("file:///android_asset/8.html");
                break;
            case 9:
                webView.loadUrl("file:///android_asset/9.html");
                break;
            case 10:
                webView.loadUrl("file:///android_asset/10.html");
                break;
            case 11:
                webView.loadUrl("file:///android_asset/11.html");
                break;
            case 12:
                webView.loadUrl("file:///android_asset/12.html");
                break;
            case 13:
                webView.loadUrl("file:///android_asset/13.html");
                break;
            case 14:
                webView.loadUrl("file:///android_asset/14.html");
                break;
        }
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pb.setVisibility(ProgressBar.INVISIBLE);
        }
    }
}