package com.example.gpo;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class TusurFet extends AppCompatActivity implements View.OnClickListener {

    private TranslateScaleView tusurFet;
    private Context context;
    private Drawable drawable;
    private VectorDrawable vectorDrawable;
    private int btnClicked;
    WifiManager mWifiManager;
    WifiReceiver mWifiReceiver;
    List<ScanResult> wifiList;
    private Button btnFirstFloor;
    private Button btnSecondFloor;
    private Button btnThirdFloor;
    private Button btnFourthFloor;
    private static final int PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION = 1;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();



        /*if((checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) ||
                (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)){
            requestPermissions(new String[] {
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    },
                    PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION);
        } else {*/
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (!mWifiManager.isWifiEnabled()) {
            // If wifi disabled then enable it
            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
            mWifiManager.setWifiEnabled(true);
        }
        mWifiReceiver = new WifiReceiver();
        IntentFilter mIntentFilter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        mIntentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        getApplicationContext().registerReceiver(mWifiReceiver, mIntentFilter);
        mWifiManager.startScan();
        //}











        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        btnFirstFloor = new Button(context);
        btnFirstFloor.setId(R.id.btn_first_floor);
        btnFirstFloor.setX(width-120);
        btnFirstFloor.setY(height*0.30f);
        btnFirstFloor.setBackgroundResource(R.drawable.ic_btn_floor1);
        btnFirstFloor.setTextSize(20);
        btnFirstFloor.setText("1");
        //btnFirstFloor.setTextColor(Color.rgb( 6, 147, 248));
        btnFirstFloor.setTextColor(Color.rgb( 217, 216, 216));

        btnSecondFloor = new Button(context);
        btnSecondFloor.setId(R.id.btn_second_floor);
        btnSecondFloor.setX(width-120);
        btnSecondFloor.setY(height*0.39f);
        btnSecondFloor.setBackgroundResource(R.drawable.ic_btn_floor1);
        btnSecondFloor.setTextSize(20);
        btnSecondFloor.setText("2");
        btnSecondFloor.setTextColor(Color.rgb(217, 216, 216));

        btnThirdFloor = new Button(context);
        btnThirdFloor.setId(R.id.btn_third_floor);
        btnThirdFloor.setX(width-120);
        btnThirdFloor.setY(height*0.48f);
        btnThirdFloor.setBackgroundResource(R.drawable.ic_btn_floor1);
        btnThirdFloor.setTextSize(20);
        btnThirdFloor.setText("3");
        btnThirdFloor.setTextColor(Color.rgb(217, 216, 216));

        btnFourthFloor = new Button(context);
        btnFourthFloor.setId(R.id.btn_fourth_floor);
        btnFourthFloor.setX(width-120);
        btnFourthFloor.setY(height*0.57f);
        btnFourthFloor.setBackgroundResource(R.drawable.ic_btn_floor1);
        btnFourthFloor.setTextSize(20);
        btnFourthFloor.setText("4");
        //btnFourthFloor.setTextColor(Color.rgb(217, 216, 216));
        btnFourthFloor.setTextColor(Color.rgb(6, 147, 248));

        /*try {
            SVG svg = SVG.getFromAsset(getAssets(), "svg/tusur_fet1.svg");
            tusurFet = new TranslateScaleView(context, svg);
        } catch (SVGParseException | IOException e) {
            e.printStackTrace();
        }*/
        //vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet1);
        vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet4_720x720);
        if (vectorDrawable != null) {
            //vectorDrawable.setBounds(0, 0, 1000, 1000);
            vectorDrawable.setBounds(0, 0, 720, 720);
        }

        tusurFet = new TranslateScaleView(context, vectorDrawable);
        setContentView(tusurFet);
        addContentView(btnFirstFloor, new ViewGroup.LayoutParams(
                100, 100
        ));
        addContentView(btnSecondFloor, new ViewGroup.LayoutParams(
                100, 100
        ));
        addContentView(btnThirdFloor, new ViewGroup.LayoutParams(
                100, 100
        ));
        addContentView(btnFourthFloor, new ViewGroup.LayoutParams(
                100, 100
        ));
        btnFirstFloor.setOnClickListener(this);
        btnSecondFloor.setOnClickListener(this);
        btnThirdFloor.setOnClickListener(this);
        btnFourthFloor.setOnClickListener(this);

        //btnClicked = R.id.btn_first_floor;
        btnClicked = R.id.btn_fourth_floor;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first_floor:
                /*try {
                    SVG svg = SVG.getFromAsset(getAssets(), "svg/tusur_fet1.svg");
                    tusurFet.setSvg(svg);
                } catch (SVGParseException | IOException e) {
                    e.printStackTrace();
                }*/
                if (btnClicked != R.id.btn_first_floor) {
                    resetButton();
                    btnFirstFloor.setTextColor(Color.rgb(6, 147, 248));
                    btnClicked = R.id.btn_first_floor;
                    vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet1);
                    if (vectorDrawable != null) {
                        vectorDrawable.setBounds(0, 0, 1000, 1000);
                    }
                    tusurFet.setVectorDrawable(vectorDrawable);
                }
                break;

            case R.id.btn_second_floor:
                /*try {
                    SVG svg = SVG.getFromAsset(getAssets(), "svg/tusur_fet2.svg");
                    tusurFet.setSvg(svg);
                } catch (SVGParseException | IOException e) {
                    e.printStackTrace();
                }*/
                if (btnClicked != R.id.btn_second_floor) {
                    resetButton();
                    btnSecondFloor.setTextColor(Color.rgb(6, 147, 248));
                    btnClicked = R.id.btn_second_floor;
                    vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet2);
                    if (vectorDrawable != null) {
                        vectorDrawable.setBounds(0, 0, 1000, 1000);
                    }
                    tusurFet.setVectorDrawable(vectorDrawable);
                }
                break;

            case R.id.btn_third_floor:
                if (btnClicked != R.id.btn_third_floor) {
                    resetButton();
                    btnThirdFloor.setTextColor(Color.rgb(6, 147, 248));
                    btnClicked = R.id.btn_third_floor;
                    vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet3);
                    if (vectorDrawable != null) {
                        vectorDrawable.setBounds(0, 0, 1000, 1000);
                    }
                    tusurFet.setVectorDrawable(vectorDrawable);
                }
                break;

            case R.id.btn_fourth_floor:
                if (btnClicked != R.id.btn_fourth_floor) {
                    resetButton();
                    btnFourthFloor.setTextColor(Color.rgb(6, 147, 248));
                    btnClicked = R.id.btn_fourth_floor;
                    vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet4);
                    if (vectorDrawable != null) {
                        vectorDrawable.setBounds(0, 0, 1000, 1000);
                    }
                    tusurFet.setVectorDrawable(vectorDrawable);
                }
        }
    }

    private void resetButton() {
        switch (btnClicked) {
            case R.id.btn_first_floor:
                btnFirstFloor.setTextColor(Color.rgb(217, 216, 216));
                break;

            case R.id.btn_second_floor:
                btnSecondFloor.setTextColor(Color.rgb(217, 216, 216));
                break;

            case R.id.btn_third_floor:
                btnThirdFloor.setTextColor(Color.rgb(217, 216, 216));
                break;

            case R.id.btn_fourth_floor:
                btnFourthFloor.setTextColor(Color.rgb(217, 216, 216));
        }
    }



    private void CalcRSSIbeetweenUserandKT( int[] rssi, int countkt, int floor)
    {

        int[][][] arraykt = new int[5][20][4];//4
        //4FloorRouters
        //lvl 8700 8170 7410 81ф0
        arraykt[4][0][0] = 49;arraykt[4][0][1] =23 ;arraykt[4][0][2] = 0;arraykt[4][0][3] = 0;
        arraykt[4][1][0] = 0;arraykt[4][1][1] =29 ;arraykt[4][1][2] = 0;arraykt[4][1][3] = 42;
        arraykt[4][2][0]= 0;arraykt[4][2][1] =14;arraykt[4][2][2] = 38;arraykt[4][2][3] = 0;
        arraykt[4][3][0] = 27;arraykt[4][3][1] =26 ;arraykt[4][3][2] = 0;arraykt[4][3][3] = 0;
        //............
        //kt
        int level=50;
        arraykt[4][4][0]= mWifiManager.calculateSignalLevel(-57,level);arraykt[4][4][1] =mWifiManager.calculateSignalLevel(-75,level) ;arraykt[4][4][2] = mWifiManager.calculateSignalLevel(-110,level);arraykt[4][4][3] = mWifiManager.calculateSignalLevel(-110,level);
        arraykt[4][5][0]= mWifiManager.calculateSignalLevel(-62,level);arraykt[4][5][1] =mWifiManager.calculateSignalLevel(-76,level) ;arraykt[4][5][2] = mWifiManager.calculateSignalLevel(-110,level);arraykt[4][5][3] = mWifiManager.calculateSignalLevel(-110,level);
        arraykt[4][6][0]= mWifiManager.calculateSignalLevel(-61,level);arraykt[4][6][1] =mWifiManager.calculateSignalLevel(-72,level);arraykt[4][6][2] = mWifiManager.calculateSignalLevel(-110,level);arraykt[4][6][3] = mWifiManager.calculateSignalLevel(-110,level);
        arraykt[4][7][0]= mWifiManager.calculateSignalLevel(-63,level);arraykt[4][7][1] =mWifiManager.calculateSignalLevel(-64,level);arraykt[4][7][2] = mWifiManager.calculateSignalLevel(-110,level);arraykt[4][7][3] = mWifiManager.calculateSignalLevel(-110,level);
        arraykt[4][8][0]= mWifiManager.calculateSignalLevel(-76,level);arraykt[4][8][1] =mWifiManager.calculateSignalLevel(-58,level);arraykt[4][8][2] = mWifiManager.calculateSignalLevel(-110,level);arraykt[4][8][3] = mWifiManager.calculateSignalLevel(-110,level);
        arraykt[4][9][0]= mWifiManager.calculateSignalLevel(-77,level);arraykt[4][9][1] =mWifiManager.calculateSignalLevel(-66,level);arraykt[4][9][2] = mWifiManager.calculateSignalLevel(-110,level);arraykt[4][9][3] = mWifiManager.calculateSignalLevel(-110,level);





        //............*/
      /*  arraykt[4][0][0] = mWifiManager.calculateSignalLevel(-35,20);arraykt[4][0][1] =mWifiManager.calculateSignalLevel(-62,20) ;
        arraykt[4][1][0] = mWifiManager.calculateSignalLevel(-74,20);arraykt[4][1][1] =mWifiManager.calculateSignalLevel(-57,20) ;
        arraykt[4][2][0]= mWifiManager.calculateSignalLevel(-63,20);arraykt[4][2][1] =mWifiManager.calculateSignalLevel(-62,20);
        arraykt[4][3][0] = mWifiManager.calculateSignalLevel(-69,20);arraykt[4][3][1] =mWifiManager.calculateSignalLevel(-60,20) ;*/


        int [][] raznica = new int [countkt][4];

        for(int i = 0; i<countkt; i++)
        {
            for(int j=0; j<4;j++)
            {
                raznica[i][j]=Math.abs(arraykt[floor ][i][j]-rssi[j]);
            }
        }

        int [] podhodit = new int [countkt];
        int [] indexmass=sortmss(rssi);
        for(int i=0; i<countkt; i++)
        {
            podhodit[i]=raznica[i][indexmass[0]]+raznica[i][indexmass[1]];
        }
        int index=0;
        int minimal = podhodit[index];
        for(int i=0; i<countkt; i++)
        {
            if(minimal>podhodit[i])
            {
                minimal=podhodit[i];
                index=i;
            }
        }
        int [] mycrd=getCoordinate(floor,index);
        Toast.makeText(getApplicationContext(), "x: "+Double.toString( mycrd[0])+"y:"+Double.toString( mycrd[1]), Toast.LENGTH_SHORT).show();


    }
    private int floor(String macadress)
    {
        int k=0;
        if(macadress.equals("28:28:5d:79:ea:7a")||macadress.equals("c8:3a:35:0f:2c:e0")) {
            k = 4;//1
        }
        if(macadress.equals("")||macadress.equals("")||macadress.equals("")||macadress.equals("")) {
            k = 2;
        }
        if(macadress.equals("")||macadress.equals("")||macadress.equals("")||macadress.equals("")) {
            k = 3;
        }
        if(macadress.equals("00:19:aa:51:81:70")||macadress.equals("00:19:aa:51:87:00")||macadress.equals("00:19:aa:51:81:f0")||macadress.equals("00:19:55:cc:74:10")) {
            k = 4;
        }
        return k;
    }
    private int[] getCoordinate(int floor, int tochka)
    {
        int [] crdarray = new int [2];
        int[][][] arrayKTcoord = new int[5][20][4];
//tipa routeri
        arrayKTcoord[4][0][0] = 0;arrayKTcoord[4][0][1] =0;
        arrayKTcoord[4][1][0] = 720;arrayKTcoord[4][1][1] =0;
        arrayKTcoord[4][2][0] = 720;arrayKTcoord[4][2][1] =720;
        arrayKTcoord[4][3][0] = 0;arrayKTcoord[4][3][1] =720;

        arrayKTcoord[4][4][0] = 0;arrayKTcoord[4][4][1] =102;
        arrayKTcoord[4][5][0] = 0;arrayKTcoord[4][5][1] =204;
        arrayKTcoord[4][6][0] = 0;arrayKTcoord[4][6][1] =306;
        arrayKTcoord[4][7][0] = 0;arrayKTcoord[4][7][1] =408;
        arrayKTcoord[4][8][0] = 0;arrayKTcoord[4][8][1] =510;
        arrayKTcoord[4][9][0] = 0;arrayKTcoord[4][9][1] =612;


        crdarray[0]=arrayKTcoord[floor][tochka][0];
        crdarray[1]=arrayKTcoord[floor][tochka][1];

        return crdarray;
    }
    private void generatearrayrssi(List<ScanResult> results)
    {
        WifiInfo wifiinfo =  mWifiManager.getConnectionInfo();
        int rssi[] = new int[4];//4
        int floor = floor(wifiinfo.getBSSID());

        if(floor!=0) {
            switch (floor) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).BSSID.equals("00:19:aa:51:87:00")) {
                            rssi[0] = mWifiManager.calculateSignalLevel(results.get(i).level, 50);
                            break;
                        } else rssi[0] = 0;
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).BSSID.equals("00:19:aa:51:81:70")) {
                            rssi[1] = mWifiManager.calculateSignalLevel(results.get(i).level, 50);
                            break;
                        } else rssi[1] = 0;
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).BSSID.equals("00:19:55:cc:74:10")) {
                            rssi[2] = mWifiManager.calculateSignalLevel(results.get(i).level, 50);
                            break;
                        } else rssi[2] = 0;
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).BSSID.equals("00:19:aa:51:81:f0")) {
                            rssi[3] = mWifiManager.calculateSignalLevel(results.get(i).level, 50);
                            break;
                        } else rssi[3] = 0;
                    }
                  /*  for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).BSSID.equals("28:28:5d:79:ea:7a")) {
                            rssi[0] = mWifiManager.calculateSignalLevel(results.get(i).level, 20);
                            break;
                        } else rssi[0] = 0;
                    }
                    for (int i = 0; i < results.size(); i++) {
                        if (results.get(i).BSSID.equals("c8:3a:35:0f:2c:e0")) {
                            rssi[1] = mWifiManager.calculateSignalLevel(results.get(i).level, 20);

                            break;
                        } else rssi[1] = 0;
                    }*/
                    Log.e("rsiiicord",Integer.toString( rssi[0])+"    "+Integer.toString( rssi[1])+"    "+Integer.toString( rssi[2])+"    "+Integer.toString( rssi[3]));
            }
            CalcRSSIbeetweenUserandKT(rssi, 10, floor);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "хз в какой мусорке ты находишься, челик", Toast.LENGTH_SHORT).show();
        }
    }
    class WifiReceiver extends BroadcastReceiver {
        // This method call when number of wifi connections changed
        public void onReceive(Context c, Intent intent) {
            int state = mWifiManager.getWifiState();
            if (state == WifiManager.WIFI_STATE_ENABLED) {
                wifiList = mWifiManager.getScanResults();
                generatearrayrssi(wifiList);
            }
        }
    }
    public void onPause() {
        if (mWifiReceiver != null) {
            getApplicationContext().unregisterReceiver(mWifiReceiver);
        }
        super.onPause();
    }

    public void onResume() {
        getApplicationContext().registerReceiver(mWifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }



    public int[] sortmss (int rssi[]) {
        int arrindex[] = {0, 1, 2, 3};
        for (int i = rssi.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (rssi[j] < rssi[j + 1]) {
                    int tmp = rssi[j];
                    rssi[j] = rssi[j + 1];
                    rssi[j + 1] = tmp;

                    tmp = arrindex[j];
                    arrindex[j] = arrindex[j + 1];
                    arrindex[j + 1] = tmp;
                    Log.e("indexmass",Integer.toString( arrindex[0])+"    "+Integer.toString( arrindex[1])+"    "+Integer.toString( arrindex[2])+"    "+Integer.toString( arrindex[3]));

                }
            }
        }
        return arrindex;
    }

}
