package com.example.gpo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CustomDialogFrament extends DialogFragment {
    private static final String PREFS_FILE = "Account";
    private static final String PREF_NAME = "Name";
    private static final String PREF_FAC = "Faculty";
    SharedPreferences settings;
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.poddialog, null);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.DialogeTheme);
        EditText edittext = (EditText) dialogView.findViewById(R.id.editText);
        settings = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        edittext.setText(settings.getString(PREF_NAME,"545"));
        builder.setView(dialogView).setCancelable(false).setPositiveButton(R.string.OK, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id) {
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.poddialog, null);
                EditText edittext = (EditText) getDialog().findViewById(R.id.editText);
                String name = edittext.getText().toString();
                if(name.length()>0) {
                    String fourth = name.substring(0, 1);
                    SharedPreferences.Editor prefEditor = settings.edit();
                    prefEditor.putString(PREF_NAME, name);
                    prefEditor.apply();
                    if (fourth.equals("1")) {prefEditor.putString(PREF_FAC, "rtf");prefEditor.apply();}
                    if (fourth.equals("2")) {prefEditor.putString(PREF_FAC, "rkf");prefEditor.apply();}
                    if (fourth.equals("3")) {prefEditor.putString(PREF_FAC, "fet");prefEditor.apply();}
                    if (fourth.equals("4")) {prefEditor.putString(PREF_FAC, "fsu");prefEditor.apply();}
                    if (fourth.equals("5")) {prefEditor.putString(PREF_FAC, "fvs");prefEditor.apply();}
                    if (fourth.equals("6")) {prefEditor.putString(PREF_FAC, "gf");prefEditor.apply();}
                    if (fourth.equals("7")) {prefEditor.putString(PREF_FAC, "ef");prefEditor.apply();}
                    if (fourth.equals("8")) {prefEditor.putString(PREF_FAC, "yuf");prefEditor.apply();}
                    if (fourth.equals("9")) {prefEditor.putString(PREF_FAC, "fb");prefEditor.apply();}
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.content, new podgruzon(),"zagruzka").commit();
                }
            }
        });
        builder.setView(dialogView).setCancelable(false).setNegativeButton("Отмена", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return builder.create();
    }



}

