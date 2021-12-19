package com.example.semesta;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AlatFragment extends Fragment {
    WebView webView;
    WebSettings webSetting;
    String GlobalToken;
    SharedPrefManager spm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return v;
    }
}