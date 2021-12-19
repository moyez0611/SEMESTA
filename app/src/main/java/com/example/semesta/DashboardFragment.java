package com.example.semesta;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DashboardFragment extends Fragment {

    String GlobalToken;
    SharedPrefManager spm;
    WebView webView;
    WebSettings webSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return v;
//        spm = new SharedPrefManager(this);
//        GlobalToken = spm.getSPStrings("spToken", "DEFAULT");
//        SharedPreferences preferences = this.getActivity().getSharedPreferences("spToken", Context.MODE_PRIVATE);
//        String api_url = getString(R.string.api_server);
        //webview
//        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

//        String url = "http://winn-brown.co.uk/";
//        WebView view = (WebView) rootView.findViewById(R.id.WebVDashboard);
//        view.loadUrl(url);
//        view.getSettings().setJavaScriptEnabled(true);
//        view.setWebViewClient(new MyWebViewClient());
//        view.setWebChromeClient(new MyWebChromeClient());
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished (WebView view, String url) {
            //Calling a javascript function in html page
            view.loadUrl("javascript:alert(showVersion('called by Android'))");
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Log.d("LogTag", message);
            result.confirm();
            return true;
        }
    }

}