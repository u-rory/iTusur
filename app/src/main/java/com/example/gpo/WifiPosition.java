package com.example.gpo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import java.util.List;
import java.util.StringJoiner;

public class WifiPosition extends AppCompatActivity {

    TextView testViewStatus;
    WifiManager wifiManager;
    BroadcastReceiver wifiScanReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wifi_position);
        testViewStatus = findViewById(R.id.status);

        wifiManager = (WifiManager)
            getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifiScanReceiver = new BroadcastReceiver() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onReceive(Context c, Intent intent) {
                scanSuccess(wifiManager.getScanResults());
                wifiManager.startScan();
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(wifiScanReceiver, intentFilter);

        boolean success = false;
        if (wifiManager != null) {
            success = wifiManager.startScan();
        }
        if (!success) {
            // scan failure handling
            scanFailure();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void scanSuccess(List<ScanResult> results) {
        StringBuilder str = new StringBuilder();
        for (ScanResult result : results) {
            String resultInfo = "address: " + result.BSSID + "\n" +
                                "network name: " + result.SSID + "\n" +
                                "venue name: " + result.venueName + "\n" +
                                "signal level: " + WifiManager.calculateSignalLevel(result.level, 20) + "\n";
            str.append(resultInfo).append("\n");
        }

        testViewStatus.setText(str.toString());
    }

    private void scanFailure() {
        testViewStatus.setText("Scan failed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(wifiScanReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(wifiScanReceiver, intentFilter);

    }

    private void showSignals(List<Integer> signals){
        if(signals == null || signals.size() == 0){
            testViewStatus.setText("No Location!");
        } else {
            testViewStatus.setText("Signals: " + signals);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showProviders(List<String> providers) {
        StringJoiner sj = new StringJoiner(",");
        for (String name : providers) {
            sj.add(name);
        }
        testViewStatus.setText(sj.toString());
    }

}
