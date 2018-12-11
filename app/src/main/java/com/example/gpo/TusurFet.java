package com.example.gpo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TusurFet extends AppCompatActivity implements View.OnClickListener {

    private TranslateScaleView tusurFet;
    private Context context;
    private Drawable drawable;
    private VectorDrawable vectorDrawable;
    private int btnClicked;

    private Button btnFirstFloor;
    private Button btnSecondFloor;
    private Button btnThirdFloor;
    private Button btnFourthFloor;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();

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
        btnFirstFloor.setTextColor(Color.rgb( 6, 147, 248));

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
        btnFourthFloor.setTextColor(Color.rgb(217, 216, 216));

        /*try {
            SVG svg = SVG.getFromAsset(getAssets(), "svg/tusur_fet1.svg");
            tusurFet = new TranslateScaleView(context, svg);
        } catch (SVGParseException | IOException e) {
            e.printStackTrace();
        }*/
        vectorDrawable = (VectorDrawable) getDrawable(R.drawable.map_tusur_fet1);
        if (vectorDrawable != null) {
            vectorDrawable.setBounds(0, 0, 1000, 1000);
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

        btnClicked = R.id.btn_first_floor;

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
}
