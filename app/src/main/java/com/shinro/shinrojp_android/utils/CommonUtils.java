package com.shinro.shinrojp_android.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class CommonUtils {

    public static void hideKeyBoard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideKeyBoardOnBlur(TextInputEditText editText) {
        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                hideKeyBoard(v);
            }
        });
    }

    public static String getSystemDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        month++;
        String m = (month < 10) ? "0" + month : String.valueOf(month);
        String d = (day < 10) ? "0" + day : String.valueOf(day);
        return year + "-" + m + "-" + d;
    }

    public static String getImageUrlForGlide(String s) {
        if(s.contains("http") || s.contains("https")){
            return s;
        }
        return "http://" + s.substring(2);
    }

    public static String getProgramUrlForWebView(String s) {
        if(s.contains("http") || s.contains("https")){
            return s;
        }
        return "http://" + s.substring(2);
    }

}
