package com.example.gpo;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;


public class FORMAPS extends Activity {
    WebView webView;
    TextView number, opis,telefon, time;
    CardView cd;
    ProgressBar pb;
    private static final String PREFS_FILE = "Account";
    private static final String PREF_ROOMS = "Rooms";
    SharedPreferences settings;
    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formaps);
        cd=(CardView) findViewById(R.id.mapscard);
        number=(TextView) findViewById(R.id.numbermaps);
        opis=(TextView) findViewById(R.id.opsimaps);
        telefon=(TextView) findViewById(R.id.telefonmaps);
        time=(TextView) findViewById(R.id.timemaps);
        pb=(ProgressBar)findViewById(R.id.pbmaps) ;

        webView = (WebView) findViewById(R.id.kartishki);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.loadUrl("file:///android_asset/index.html");
        webView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
             //  cd.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
               pb.setVisibility(View.INVISIBLE);
            }
        });
        webView.addJavascriptInterface(new Object()
        {

            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("emptyField");
            }
        }, "emptyField");
        webView.addJavascriptInterface(new Object()
        {

        @JavascriptInterface
        public void Click()
        {
                new MyTask().execute("room103");
              }
        }, "room103");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room104");
            }
        }, "room104");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("diningRoom");
            }
        }, "diningRoom");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room107");
            }
        }, "room107");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room108");
            }
        }, "room108");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room109");
            }
        }, "room109");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room110");
            }
        }, "room110");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room111");
            }
        }, "room111");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room112");
            }
        }, "room112");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room113");
            }
        }, "room113");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room114");
            }
        }, "room114");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room115");
            }
        }, "room115");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room116");
            }
        }, "room116");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room117");
            }
        }, "room117");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room118");
            }
        }, "room118");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room120");
            }
        }, "room120");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room121");
            }
        }, "room121");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room122");
            }
        }, "room122");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room123");
            }
        }, "room123");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room126");
            }
        }, "room126");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room127");
            }
        }, "room127");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room128");
            }
        }, "room128");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room129");
            }
        }, "room129");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room130");
            }
        }, "room130");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room134");
            }
        }, "room134");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room135");
            }
        }, "room135");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room137");
            }
        }, "room137");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room139");
            }
        }, "room139");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room141");
            }
        }, "room141");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room145");
            }
        }, "room145");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room108mk");
            }
        }, "room108mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room109mk");
            }
        }, "room109mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room110mk");
            }
        }, "room110mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room111mk");
            }
        }, "room111mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room112mk");
            }
        }, "room112mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room113mk");
            }
        }, "room113mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room114mk");
            }
        }, "room114mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room115mk");
            }
        }, "room115mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room116mk");
            }
        }, "room116mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room117mk");
            }
        }, "room117mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room118mk");
            }
        }, "room118mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room119mk");
            }
        }, "room119mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room202");
            }
        }, "room202");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room203");
            }
        }, "room203");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room205");
            }
        }, "room205");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room206");
            }
        }, "room206");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room207");
            }
        }, "room207");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room208");
            }
        }, "room208");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room209");
            }
        }, "room209");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room210");
            }
        }, "room210");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room211");
            }
        }, "room211");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room212");
            }
        }, "room212");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room213");
            }
        }, "room213");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room214");
            }
        }, "room214");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room215");
            }
        }, "room215");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room216");
            }
        }, "room216");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room217");
            }
        }, "room217");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room219");
            }
        }, "room219");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room220");
            }
        }, "room220");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room221");
            }
        }, "room221");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room222");
            }
        }, "room222");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room223");
            }
        }, "room223");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room224");
            }
        }, "room224");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room226");
            }
        }, "room226");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room227");
            }
        }, "room227");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room228");
            }
        }, "room228");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room229");
            }
        }, "room229");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room231");
            }
        }, "room231");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room232");
            }
        }, "room232");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room233");
            }
        }, "room233");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room234");
            }
        }, "room234");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room236");
            }
        }, "room236");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room240");
            }
        }, "room240");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room203mk");
            }
        }, "room203mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room204mk");
            }
        }, "room204mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room205mk");
            }
        }, "room205mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room206mk");
            }
        }, "room206mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room207mk");
            }
        }, "room207mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room208mk");
            }
        }, "room208mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room209mk");
            }
        }, "room209mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room210mk");
            }
        }, "room210mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room211mk");
            }
        }, "room211mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room212mk");
            }
        }, "room212mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room213mk");
            }
        }, "room213mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room214mk");
            }
        }, "room214mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room215mk");
            }
        }, "room215mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room216mk");
            }
        }, "room216mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room217mk");
            }
        }, "room217mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room218mk");
            }
        }, "room218mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room219mk");
            }
        }, "room219mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room220mk");
            }
        }, "room220mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room221mk");
            }
        }, "room221mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room223mk");
            }
        }, "room223mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room301");
            }
        }, "room301");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room302");
            }
        }, "room302");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room309");
            }
        }, "room309");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room310");
            }
        }, "room310");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room313");
            }
        }, "room313");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room315");
            }
        }, "room315");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                //new MyTask().execute("roomact");
            }
        }, "roomact");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room316");
            }
        }, "room316");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room318");
            }
        }, "room318");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room320");
            }
        }, "room320");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room324");
            }
        }, "room324");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room327");
            }
        }, "room327");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room303mk");
            }
        }, "room303mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room304mk");
            }
        }, "rroom304mkoom");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room305mk");
            }
        }, "room305mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room306mk");
            }
        }, "room306mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room307mk");
            }
        }, "room307mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room309mk");
            }
        }, "room309mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room310mk");
            }
        }, "room310mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room311mk");
            }
        }, "room311mk");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room403");
            }
        }, "room403");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room405");
            }
        }, "room405");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room406");
            }
        }, "room406");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room408");
            }
        }, "room408");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room409");
            }
        }, "room409");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room412");
            }
        }, "room412");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room415");
            }
        }, "room415");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room4161");
            }
        }, "room4161");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room4162");
            }
        }, "room4162");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room417");
            }
        }, "room417");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room418");
            }
        }, "room418");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room419");
            }
        }, "room419");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room4192");
            }
        }, "room4192");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room420");
            }
        }, "room420");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room421");
            }
        }, "room421");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room422");
            }
        }, "room422");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room424");
            }
        }, "room424");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room425");
            }
        }, "room425");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room426");
            }
        }, "room426");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room427");
            }
        }, "room427");
        webView.addJavascriptInterface(new Object()
        {
            @JavascriptInterface
            public void Click()
            {
                new MyTask().execute("room431");
            }
        }, "room431");
    }

public class MyTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... params) {
        return params[0];
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        settings = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        String podnumber = settings.getString(PREF_ROOMS, "0");

        if (!podnumber.equals(result)) {
            Log.e("a", podnumber);
            Log.e("a", result);
            vis();
            if (result.equals("room103")) {
                number.setText("103");
                opis.setText("Научно-образовательный-центр гуманитарного факультета\nКафедра философии и социологии");
                prefEditor.putString(PREF_ROOMS, "room103");
            }
            if (result.equals("room104")) {
                number.setText("104");
                opis.setText("Касса");
                prefEditor.putString(PREF_ROOMS, "room104");
            }
            if (result.equals("diningRoom")) {
                number.setText("Столовая");
                opis.setText("Пн-пт: 9:00-17:00");
                prefEditor.putString(PREF_ROOMS, "diningRoom");
            }
            if (result.equals("room107")) {
                number.setText("107");
                opis.setText("Бухгалтерия\nНалоговая группа");
                prefEditor.putString(PREF_ROOMS, "room107");
            }
            if (result.equals("room108")) {
                number.setText("108");
                opis.setText("Заместитель главного бухгалтера, расчетная группа по заработной плате");
                time.setText("08:30 - 17:30 \n13:00-14:00 - Перерыв \nc 14:00 Прием сотрудников");
                prefEditor.putString(PREF_ROOMS, "room108");
            }
            if (result.equals("room109")) {
                number.setText("109");
                opis.setText("Заместитель главного бухгалтера, юрисконсульт финансового управления");
                prefEditor.putString(PREF_ROOMS, "room109");

            }
            if (result.equals("room110")) {
                number.setText("110");
                opis.setText("Бухгалтерия\nРасчеты с арендаторами и физическими лицами");
                prefEditor.putString(PREF_ROOMS, "room110");
            }
            if (result.equals("room111")) {
                number.setText("111");
                opis.setText("Бухгалтерия\nФинансовая группа");
                prefEditor.putString(PREF_ROOMS, "room111");
            }
            if (result.equals("room112")) {
                number.setText("112");
                opis.setText("Начальник отдела лицензирования, аккредитации и качества образования\nКормилин Валерий Анатольевич");
                prefEditor.putString(PREF_ROOMS, "room112");
            }
            if (result.equals("room113")) {
                number.setText("113");
                opis.setText("Центр ТУСУР-ТЕЛЕКОМ");
                prefEditor.putString(PREF_ROOMS, "room113");
            }
            if (result.equals("room114")) {
                number.setText("114");
                opis.setText("Ответственный секретарь приемной комиссии\nМозгунов Алексей Викторович");
                prefEditor.putString(PREF_ROOMS, "room114");
            }
            if (result.equals("room115")) {
                number.setText("115");
                opis.setText("Бухгалтерия\nРасчеты по договорам НИИ");
                prefEditor.putString(PREF_ROOMS, "room115");
            }
            if (result.equals("room116")) {
                number.setText("116");
                opis.setText("Канцелярия");
                prefEditor.putString(PREF_ROOMS, "room116");
            }
            if (result.equals("room117")) {
                number.setText("117");
                opis.setText("Инновационное управление\nНачальник Инновационного управления");
                prefEditor.putString(PREF_ROOMS, "room117");
            }
            if (result.equals("room118")) {
                number.setText("118");
                opis.setText("Профком сотрудников");
                prefEditor.putString(PREF_ROOMS, "room118");
            }
            if (result.equals("room120")) {
                number.setText("120");
                opis.setText("Лаборатория печатной электроники кафедры КУДР");
                prefEditor.putString(PREF_ROOMS, "room120");
            }
            if (result.equals("room121")) {
                number.setText("121");
                opis.setText("Бухгалтерия\nСтипендиальная группа");
                time.setText("ПН-ЧТ 14:00-17:45\nПТ 14:00-16:30");
                prefEditor.putString(PREF_ROOMS, "room121");
            }
            if (result.equals("room122")) {
                number.setText("122");
                opis.setText("Лаборатория группового проектного обучения(ГПО) кафедры КУДР");
                prefEditor.putString(PREF_ROOMS, "room122");
            }
            if (result.equals("room123")) {
                number.setText("123");
                opis.setText("Бухгалтерия\nГруппа расчетов с подотчетными и юридическими лицами");
                prefEditor.putString(PREF_ROOMS, "room123");
            }
            if (result.equals("room126")) {
                number.setText("126");
                opis.setText("МАШБЮРО");
                prefEditor.putString(PREF_ROOMS, "room126");
            }
            if (result.equals("room127")) {
                number.setText("127");
                opis.setText("Институт дополнительного образования");
                prefEditor.putString(PREF_ROOMS, "room127");
            }
            if (result.equals("room128")) {
                number.setText("128");
                opis.setText("Проректор\nАгафонников В.Ф.");
                prefEditor.putString(PREF_ROOMS, "room128");
            }
            if (result.equals("room129")) {
                number.setText("129");
                opis.setText("Приемная комиссия");
                prefEditor.putString(PREF_ROOMS, "room129");
            }
            if (result.equals("room130")) {
                number.setText("130");
                opis.setText("Начальник отдела кадров");
                prefEditor.putString(PREF_ROOMS, "room130");
            }
            if (result.equals("room134")) {
                number.setText("134");
                opis.setText("Управление связи и коммуникации");
                prefEditor.putString(PREF_ROOMS, "room134");
            }
            if (result.equals("room135")) {
                number.setText("135");
                opis.setText("Препродавательская");
                prefEditor.putString(PREF_ROOMS, "room135");
            }
            if (result.equals("room137")) {
                number.setText("137");
                opis.setText("Бухгалтерия\nМатериальная группа");
                prefEditor.putString(PREF_ROOMS, "room137");
            }
            if (result.equals("room139")) {
                number.setText("139");
                opis.setText("Кафедра ИСР");
                time.setText("Служба сопровождения студентов с ограниченными возможностями здоровья");
                prefEditor.putString(PREF_ROOMS, "room139");
            }
            if (result.equals("room141")) {
                number.setText("141");
                opis.setText("Отдел кадров сотрудников");
                prefEditor.putString(PREF_ROOMS, "room141");
            }
            if (result.equals("room145")) {
                number.setText("145");
                opis.setText("Студентческий отдел кадров");
                time.setText("ПН-ПТ 12:00-13:00\n 14:00-16:30");
                prefEditor.putString(PREF_ROOMS, "room145");
            }
            if (result.equals("room108mk")) {
                number.setText("108м/к");
                opis.setText("Начальник эксплуатационно-технического отдела");
                prefEditor.putString(PREF_ROOMS, "room108mk");
            }
            if (result.equals("room110mk")) {
                number.setText("110м/к");
                opis.setText("Начальник материально-технического снабжения");
                prefEditor.putString(PREF_ROOMS, "room110mk");
            }
            if (result.equals("room111mk")) {
                number.setText("111м/к");
                opis.setText("Эксплуатационно-технический отдел");
                prefEditor.putString(PREF_ROOMS, "room111mk");
            }
            if (result.equals("room112mk")) {
                number.setText("112м/к");
                opis.setText("Отдел по управлению имуществом");
                prefEditor.putString(PREF_ROOMS, "room112mk");
            }
            if (result.equals("room113mk")) {
                number.setText("113м/к");
                opis.setText("Отдел материально-технического снабжения");
                prefEditor.putString(PREF_ROOMS, "room113mk");
            }
            if (result.equals("room114mk")) {
                number.setText("114м/к");
                opis.setText("Отдел по управлению имуществом(аренда)");
                prefEditor.putString(PREF_ROOMS, "room114mk");
            }
            if (result.equals("room115mk")) {
                number.setText("115м/к");
                opis.setText("Инженеры ОКСа");
                prefEditor.putString(PREF_ROOMS, "room115mk");
            }
            if (result.equals("room116mk")) {
                number.setText("116м/к");
                opis.setText("Начальник ОКСа\nНачальник ПТО");
                prefEditor.putString(PREF_ROOMS, "room116mk");
            }
            if (result.equals("room117mk")) {
                number.setText("117м/к");
                opis.setText("Сметный отдел");
                prefEditor.putString(PREF_ROOMS, "room117mk");
            }
            if (result.equals("room119mk")) {
                number.setText("119м/к");
                opis.setText("Водители транспортного отдела");
                prefEditor.putString(PREF_ROOMS, "room119mk");
            }
            //2 et
            if (result.equals("room202")) {
                number.setText("202");
                opis.setText("Секретарь ученого совета \nПрокопчук Елена Викторовна");
                prefEditor.putString(PREF_ROOMS, "room202");
            }
            if (result.equals("room203")) {
                number.setText("203");
                opis.setText("Зал заседаний Ученого Совета");
                prefEditor.putString(PREF_ROOMS, "room203");
            }
            if (result.equals("room205")) {
                number.setText("205");
                opis.setText("НАУЧНОЕ УПРАВЛЕНИЕ");
                time.setText("Отделение послевузовского профессионального образования. \nОтдел аспирантуры и докторантуры \nОтдел НИРС");
                prefEditor.putString(PREF_ROOMS, "room205");
            }
            if (result.equals("room206")) {
                number.setText("206");
                opis.setText("Начальник административно-хозяйственного управления доцент, к.т.н.\nТроян Олег Ефимович");
                prefEditor.putString(PREF_ROOMS, "room206");
            }
            if (result.equals("room207")) {
                number.setText("207");
                opis.setText("Руководитель управления информатизации\nНосуленко Александр Владимирович");
                prefEditor.putString(PREF_ROOMS, "room207");
            }
            if (result.equals("room208")) {
                number.setText("208");
                opis.setText("Отдел организации и планирования НИОКР");
                prefEditor.putString(PREF_ROOMS, "room208");
            }
            if (result.equals("room209")) {
                number.setText("209");
                opis.setText("Управление связи и коммуникаций");
                prefEditor.putString(PREF_ROOMS, "room209");
            }
            if (result.equals("room210")) {
                number.setText("210");
                opis.setText("Научное управление \nНачальник научного управления");
                prefEditor.putString(PREF_ROOMS, "room210");
            }
            if (result.equals("room211")) {
                number.setText("211");
                opis.setText("Приемная ректора");
                prefEditor.putString(PREF_ROOMS, "room211");
            }
            if (result.equals("room212")) {
                number.setText("212");
                opis.setText("Отдел организации и планирования НИОКР");
                prefEditor.putString(PREF_ROOMS, "room212");
            }
            if (result.equals("room213")) {
                number.setText("213");
                opis.setText("МУЗЕЙ ИСТОРИИ ТУСУРА");
                prefEditor.putString(PREF_ROOMS, "room213");
            }
            if (result.equals("room214")) {
                number.setText("214");
                opis.setText("НАУЧНО-ИССЛЕДОВАТЕЛЬСКАЯ ЧАСТЬ");
                prefEditor.putString(PREF_ROOMS, "room214");
            }
            if (result.equals("room215")) {
                number.setText("215");
                opis.setText("Отдел коммерциализации разработок");
                prefEditor.putString(PREF_ROOMS, "room215");
            }
            if (result.equals("room216")) {
                number.setText("216");
                opis.setText("Проректор по научной работе и инновациям профессор, д.т.н.\nМещеряков роман Валерьевич");
                prefEditor.putString(PREF_ROOMS, "room216");
            }
            if (result.equals("room217")) {
                number.setText("217");
                opis.setText("ОТДЕЛ МЕЖДУНАРОДНОГО СОТРУДНИЧЕСТВА");
                prefEditor.putString(PREF_ROOMS, "room217");
            }
            if (result.equals("room219")) {
                number.setText("219");
                opis.setText("Начальник Управления связи и коммуникаций \nЛанкин Виктор Георгиевич");
                prefEditor.putString(PREF_ROOMS, "room219");
            }
            if (result.equals("room220")) {
                number.setText("220");
                opis.setText("Департамент образования\nУчебное управление. Учебный отдел");
                prefEditor.putString(PREF_ROOMS, "room220");
            }
            if (result.equals("room221")) {
                number.setText("221");
                opis.setText("КАФЕДРА ИСТОРИИ И СОЦИАЛЬНОЙ РАБОТЫ");
                prefEditor.putString(PREF_ROOMS, "room221");
            }
            if (result.equals("room222")) {
                number.setText("222");
                opis.setText("Отдел лицензирования, аккредитации и качества образования");
                prefEditor.putString(PREF_ROOMS, "room222");
            }
            if (result.equals("room223")) {
                number.setText("223");
                opis.setText("Проректор по развитию университетского комплекса и социальной работе, к.т.н.\nБуинцев Дмитрий Николаевич");
                prefEditor.putString(PREF_ROOMS, "room223");
            }
            if (result.equals("room224")) {
                number.setText("224");
                opis.setText("Отдел сопровождения образовательного процесса");
                prefEditor.putString(PREF_ROOMS, "room224");
            }
            if (result.equals("room226")) {
                number.setText("226");
                opis.setText("Управление связи и коммуникаций");
                prefEditor.putString(PREF_ROOMS, "room226");
            }
            if (result.equals("room227")) {
                number.setText("227");
                opis.setText("Финансово-аналитический отдел. Начальник отдела\nАндреева Елена Николаевна");
                prefEditor.putString(PREF_ROOMS, "room227");
            }
            if (result.equals("room228")) {
                number.setText("228");
                opis.setText("ФИНАНСОВО-АНАЛИТИЧЕСКИЙ ОТДЕЛ");
                prefEditor.putString(PREF_ROOMS, "room228");
            }
            if (result.equals("room229")) {
                number.setText("229");
                opis.setText("Декан гуманитарного факультета. Зав.кафедрой ФиС\nСуслова Татьяна Ивановна");
                prefEditor.putString(PREF_ROOMS, "room229");
            }
            if (result.equals("room231")) {
                number.setText("231");
                opis.setText("Кафедра философии и социологии");
                prefEditor.putString(PREF_ROOMS, "room231");
            }
            if (result.equals("room232")) {
                number.setText("232");
                opis.setText("Деканат гуманитарного факультета");
                prefEditor.putString(PREF_ROOMS, "room232");
            }
            if (result.equals("room233")) {
                number.setText("233");
                opis.setText("УЧЕБНО-МЕТОДИЧЕСКИЙ КАБИНЕТ ГУМАНИТАРНЫХ НАУК");
                time.setText("Ежедневно: с 8:30 до 14:30");
                prefEditor.putString(PREF_ROOMS, "room233");
            }
            if (result.equals("room234")) {
                number.setText("234");
                opis.setText("Заведующий кафедрой истории и социальной работы\nГрик Николай Антонович");
                prefEditor.putString(PREF_ROOMS, "room234");
            }
            if (result.equals("room236")) {
                number.setText("236");
                opis.setText("Профком студентов");
                prefEditor.putString(PREF_ROOMS, "room236");
            }
            if (result.equals("room240")) {
                number.setText("240");
                opis.setText("Факультет повышения квалификации");
                prefEditor.putString(PREF_ROOMS, "room240");
            }
            if (result.equals("room203mk")) {
                number.setText("203м/к");
                opis.setText("НИИ космических технологий. Директор");
                prefEditor.putString(PREF_ROOMS, "room203mk");
            }
            if (result.equals("room204mk")) {
                number.setText("204м/к");
                opis.setText("Главный инженер ТУСУР");
                prefEditor.putString(PREF_ROOMS, "room204mk");
            }
            if (result.equals("room205mk")) {
                number.setText("205м/к");
                opis.setText("НИИ космических технологий");
                prefEditor.putString(PREF_ROOMS, "room205mk");
            }
            if (result.equals("room206mk")) {
                number.setText("206м/к");
                opis.setText("СМАРТ\nЛаборатория группового обучения и прикладных исследований кафедры ФиС");
                prefEditor.putString(PREF_ROOMS, "room206mk");
            }
            if (result.equals("room207mk")) {
                number.setText("207м/к");
                opis.setText("НИИ космических технологий");
                prefEditor.putString(PREF_ROOMS, "room207mk");
            }
            if (result.equals("room208mk")) {
                number.setText("208м/к");
                opis.setText("Начальник службы безопасности");
                prefEditor.putString(PREF_ROOMS, "room208mk");
            }
            if (result.equals("room209mk")) {
                number.setText("209м/к");
                opis.setText("Заочный и вечерный факультет");
                time.setText("Понедельник - пятница\nс 9:00 до 12:00\nc 14:00 до 16:30");
                prefEditor.putString(PREF_ROOMS, "room209mk");
            }
            if (result.equals("room210mk")) {
                number.setText("210м/к");
                opis.setText("НИИ космических технологий");
                prefEditor.putString(PREF_ROOMS, "room210mk");
            }
            if (result.equals("room211mk")) {
                number.setText("211м/к");
                opis.setText("Инструктор по ПБ");
                prefEditor.putString(PREF_ROOMS, "room211mk");
            }
            if (result.equals("room212mk")) {
                number.setText("212м/к");
                opis.setText("Декан заочного и вечернего факультета");
                prefEditor.putString(PREF_ROOMS, "room212mk");
            }
            if (result.equals("room213mk")) {
                number.setText("213м/к");
                opis.setText("Начальник штаба ГО и ЧС");
                prefEditor.putString(PREF_ROOMS, "room213mk");
            }
            if (result.equals("room214mk")) {
                number.setText("214м/к");
                opis.setText("Архив финансового управления");
                prefEditor.putString(PREF_ROOMS, "room214mk");
            }
            if (result.equals("room215mk")) {
                number.setText("215м/к");
                opis.setText("Заведующий хозяйством. Комендант");
                prefEditor.putString(PREF_ROOMS, "room215mk");
            }
            if (result.equals("room216mk")) {
                number.setText("216м/к");
                opis.setText("Юридическая служба");
                prefEditor.putString(PREF_ROOMS, "room216mk");
            }
            if (result.equals("room217mk")) {
                number.setText("217м/к");
                opis.setText("ТУС <ТВ-ТУСУР>");
                prefEditor.putString(PREF_ROOMS, "room217mk");
            }
            if (result.equals("room218mk")) {
                number.setText("218м/к");
                opis.setText("Отдел охраны");
                prefEditor.putString(PREF_ROOMS, "room218mk");
            }
            if (result.equals("room219mk")) {
                number.setText("219м/к");
                opis.setText("Юридическая служба. Контрактная служба");
                prefEditor.putString(PREF_ROOMS, "room219mk");
            }
            if (result.equals("room220mk")) {
                number.setText("220м/к");
                opis.setText("Патентно-информационный отдел");
                prefEditor.putString(PREF_ROOMS, "room220mk");
            }
            if (result.equals("room221mk")) {
                number.setText("221м/к");
                opis.setText("Контрактная служба");
                prefEditor.putString(PREF_ROOMS, "room221mk");
            }
            if (result.equals("room223mk")) {
                number.setText("223м/к");
                opis.setText("Заведующий кафедрой космических радиоэлектронных устройств\nСунцов Сергей Борисович");
                prefEditor.putString(PREF_ROOMS, "room223mk");
            }
            //3et
            if (result.equals("room301")) {
                number.setText("301");
                opis.setText("Методический кабинет");
                prefEditor.putString(PREF_ROOMS, "room301");
            }
            if (result.equals("room302")) {
                number.setText("302");
                opis.setText("Компьютерный класс КИПР");
                prefEditor.putString(PREF_ROOMS, "room302");
            }
            if (result.equals("room309")) {
                number.setText("309");
                opis.setText("Организационно-методический отдел");
                prefEditor.putString(PREF_ROOMS, "room309");
            }
            if (result.equals("room310")) {
                number.setText("310");
                opis.setText("Бюро расписания");
                time.setText("ПН-ПТ\n8:30-17:30\n Обед 13:30-14:30");
                prefEditor.putString(PREF_ROOMS, "room310");
            }
            if (result.equals("room313")) {
                number.setText("313");
                opis.setText("Заместитель декана РКФ\n Поляковой С.А.");
                time.setText("ПН(четная) 11:00-12:00\nСреда(нечетная) 11:00-12:00 \nЧетверг 12:30-13:00 \nПятница 12:20-13:00");
                prefEditor.putString(PREF_ROOMS, "room313");
            }
            if (result.equals("room315")) {
                number.setText("315");
                opis.setText("Декан РФ");
                prefEditor.putString(PREF_ROOMS, "room315");
            }
            if (result.equals("room316")) {
                number.setText("316");
                opis.setText("Измерительная лаборатория к.КУДР");
                prefEditor.putString(PREF_ROOMS, "room316");
            }
            if (result.equals("room318")) {
                number.setText("318");
                opis.setText("Заведующий к.КУДР");
                prefEditor.putString(PREF_ROOMS, "room318");
            }
            if (result.equals("room320")) {
                number.setText("320");
                opis.setText("Служба охраны труда");
                prefEditor.putString(PREF_ROOMS, "room320");
            }
            if (result.equals("room324")) {
                number.setText("324");
                opis.setText("Кабинет метод. обеспечения к.КУДР");
                prefEditor.putString(PREF_ROOMS, "room324");
            }
            if (result.equals("room327")) {
                number.setText("327");
                opis.setText("Преподавательская к.КУДР");
                prefEditor.putString(PREF_ROOMS, "room327");
            }
            if (result.equals("room303mk")) {
                number.setText("303м/к");
                opis.setText("Редакция газеты <Радиоэлектроник>");
                prefEditor.putString(PREF_ROOMS, "room303mk");
            }
            if (result.equals("room304mk")) {
                number.setText("304м/к");
                opis.setText("Пресс-служба");
                prefEditor.putString(PREF_ROOMS, "room304mk");
            }
            if (result.equals("room305mk")) {
                number.setText("305м/к");
                opis.setText("Отдел маркетинга и рекламы");
                prefEditor.putString(PREF_ROOMS, "room305mk");
            }
            if (result.equals("room306mk")) {
                number.setText("306м/к");
                opis.setText("Служба актуализации контента");
                prefEditor.putString(PREF_ROOMS, "room306mk");
            }
            if (result.equals("room307mk")) {
                number.setText("307м/к");
                opis.setText("Группа учета и контроля");
                prefEditor.putString(PREF_ROOMS, "room307mk");
            }
            if (result.equals("room309mk")) {
                number.setText("309м/к");
                opis.setText("Главный энергетик ТУСУР");
                prefEditor.putString(PREF_ROOMS, "room309mk");
            }
            if (result.equals("room310mk")) {
                number.setText("310м/к");
                opis.setText("Редакция журнала <Доклады ТУСУР>");
                prefEditor.putString(PREF_ROOMS, "room310mk");
            }
            if (result.equals("room311mk")) {
                number.setText("311м/к");
                opis.setText("Кафедра высшей математики");
                prefEditor.putString(PREF_ROOMS, "room311mk");
            }
            //4et
            if (result.equals("room403")) {
                number.setText("403");
                opis.setText("Лаборатория ГПО кафедры КИПР\nЛаборатория автоматизированного проектирования");
                prefEditor.putString(PREF_ROOMS, "room403");
            }
            if (result.equals("room405")) {
                number.setText("405");
                opis.setText("Лаборатория проектирования микроволновых устройств");
                prefEditor.putString(PREF_ROOMS, "room405");
            }
            if (result.equals("room406")) {
                number.setText("406");
                opis.setText("Базовая кафедра <Конструировние радиоэлектронных средств> АО <Полюс>");
                prefEditor.putString(PREF_ROOMS, "room406");
            }
            if (result.equals("room408")) {
                number.setText("408");
                opis.setText("Кафедра КИПР");
                prefEditor.putString(PREF_ROOMS, "room408");
            }
            if (result.equals("room409")) {
                number.setText("409");
                opis.setText("Д.т.н. профессор\nТатаринов Виктор Николаевич");
                prefEditor.putString(PREF_ROOMS, "room409");
            }
            if (result.equals("room412")) {
                number.setText("412");
                opis.setText("Заведующий кафедрой КИПР к.ф.-м.н.\nКарабан Вадим Михайлович");
                prefEditor.putString(PREF_ROOMS, "room412");
            }
            if (result.equals("room415")) {
                number.setText("415");
                opis.setText("Отдел метрологии ТУСУР");
                prefEditor.putString(PREF_ROOMS, "room415");
            }
            if (result.equals("room4161")) {
                number.setText("416/1");
                opis.setText("Лаборатория безопасности жизнедеятельности кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room4161");
            }
            if (result.equals("room4162")) {
                number.setText("416/2");
                opis.setText("Лаборатория экологического мониторинга кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room4162");
            }
            if (result.equals("room417")) {
                number.setText("417");
                opis.setText("Лаборатория технологии РЭС каф.РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room417");
            }
            if (result.equals("room418")) {
                number.setText("418");
                opis.setText("Кабинет методической работы кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room418");
            }
            if (result.equals("room419")) {
                number.setText("419");
                opis.setText("Лаборатория технологии РЭС и безопасности жизнедеятельности кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room419");
            }
            if (result.equals("room4192")) {
                number.setText("419/2");
                opis.setText("Учебная аудитория кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room4192");
            }
            if (result.equals("room420")) {
                number.setText("420");
                opis.setText("Ассистентская кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room420");
            }
            if (result.equals("room421")) {
                number.setText("421");
                opis.setText("Заведующий кафедрой РЭТЭМ, директор НИИ светодиодных технологий д.т.н.\nТуев Василий Иванович");
                prefEditor.putString(PREF_ROOMS, "room421");
            }
            if (result.equals("room422")) {
                number.setText("422");
                opis.setText("Препараторская по химии кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room422");
            }
            if (result.equals("room424")) {
                number.setText("424");
                opis.setText("Лаборатория химии кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room424");
            }
            if (result.equals("room425")) {
                number.setText("425");
                opis.setText("Вычислительная лаборатория кафедры КУДР");
                prefEditor.putString(PREF_ROOMS, "room425");
            }
            if (result.equals("room426")) {
                number.setText("426");
                opis.setText("Студенческое конструкторское бюро <Сталкер> кафедры КУДР");
                prefEditor.putString(PREF_ROOMS, "room426");
            }
            if (result.equals("room427")) {
                number.setText("427");
                opis.setText("Лаборатория радиоматериалов и радиокомпонентов кафедры КУДР");
                prefEditor.putString(PREF_ROOMS, "room427");
            }
            if (result.equals("room431")) {
                number.setText("431");
                opis.setText("Преподавательская кафедры РЭТЭМ");
                prefEditor.putString(PREF_ROOMS, "room431");
            }
            if (result.equals("emptyField")) {
                prefEditor.putString(PREF_ROOMS, "emptyField");
                cd.setVisibility(View.INVISIBLE);
            }
            gonepls();
            prefEditor.apply();
        }
    }
    }
    public void vis()
    {
        opis.setText("");
        time.setText("");
        telefon.setText("");
        number.setText("");
        opis.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
        telefon.setVisibility(View.VISIBLE);
        number.setVisibility(View.VISIBLE);
    }
    public void gonepls()
    {
       if(opis.getText().toString().equals(""))
       {
           opis.setVisibility(View.GONE);
       }
        if(time.getText().toString().equals(""))
        {
            time.setVisibility(View.GONE);
        }
        if(telefon.getText().toString().equals(""))
        {
            telefon.setVisibility(View.GONE);
        }
        if(number.getText().toString().equals(""))
        {
            number.setVisibility(View.GONE);
        }
        cd.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
