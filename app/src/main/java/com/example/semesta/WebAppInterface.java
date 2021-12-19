package com.example.semesta;
import android.content.Context;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class WebAppInterface {
    Context mContext;

    // Instantiate the interface and set the context
    WebAppInterface(Context c) {
        mContext = c;
    }    @JavascriptInterface
    public String Token(){
        SharedPrefManager spm = new SharedPrefManager(mContext);
        String Token = spm.getSPStrings("spToken", "DEFAULT");
        return Token;
    }

    // Show a toast from the web page
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public int getAndroidVersion() {
        return Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public void showAndroidVersion(String versionName) {
        Toast.makeText(mContext, versionName, Toast.LENGTH_SHORT).show();
    }
}
