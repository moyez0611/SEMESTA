package com.example.semesta;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;

public class SharedPrefManager {
    public static final String SP_SIMASET_APP = "spSimasetApp";

    public static final String SP_NAMA = "spNama";
    public static final String SP_TOKEN = "spToken";
    public static final String SP_UNAME = "spUname";
    public static final String SP_GID = "spGid";
    public static final String SP_UID = "spUid";
    public static final String SP_EID = "spEid";
    public static final String SP_AVATAR = "spAvatar";


    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    static SharedPreferences.Editor spEditor;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_SIMASET_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public static void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPStrings(String keySp, String DefVal){
        return sp.getString(keySp,DefVal);
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
