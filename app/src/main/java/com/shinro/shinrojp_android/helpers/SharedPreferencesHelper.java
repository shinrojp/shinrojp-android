package com.shinro.shinrojp_android.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.shinro.shinrojp_android.utils.Constants;

public class SharedPreferencesHelper extends Constants {

    private static SharedPreferencesHelper sharedPreferencesHelper;
    private  SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static SharedPreferencesHelper getInstance(Context context) {
        if(sharedPreferencesHelper == null) {
            sharedPreferencesHelper = new SharedPreferencesHelper(context);
        }
        return sharedPreferencesHelper;
    }

    public SharedPreferencesHelper(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    }

    public void saveDataToPref(String k, String v) {
        editor = preferences.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public void saveDataToPref(String k, int v) {
        editor = preferences.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public void saveDataToPref(String k, float v) {
        editor = preferences.edit();
        editor.putFloat(k, v);
        editor.commit();
    }

    public void saveDataToPref(String k, boolean v) {
        editor = preferences.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public String getDataFromPref(String k, String def_v) {
        return preferences.getString(k, def_v);
    }

    public int getDataFromPref(String k, int def_v) {
        return preferences.getInt(k, def_v);
    }

    public float getDataFromPref(String k, float def_v) {
        return preferences.getFloat(k, def_v);
    }

    public boolean getDataFromPref(String k, boolean def_v) {
        return preferences.getBoolean(k, def_v);
    }

    public void resetPref() {
        editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    public void removeElementFromPref(String k) {
        editor = preferences.edit();
        editor.remove(k);
        editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirst) {
        editor = preferences.edit();
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirst);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
