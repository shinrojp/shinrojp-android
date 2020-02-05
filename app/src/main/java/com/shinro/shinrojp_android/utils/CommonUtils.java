package com.shinro.shinrojp_android.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.shashank.sony.fancytoastlib.FancyToast;

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

    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    //FancyToast
    public static void showToast(Context context, String message) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_SHORT, FancyToast.DEFAULT,true).show();
    }

    public static void showSuccessToast(Context context, String message) {
        FancyToast.makeText(context, message ,FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,true).show();
    }

    public static void showInfoToast(Context context, String message) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_SHORT, FancyToast.INFO,true).show();
    }

    public static void showWarningToast(Context context, String message) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_SHORT, FancyToast.WARNING,true).show();
    }

    public static void showErrorToast(Context context, String message) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_SHORT, FancyToast.ERROR,true).show();
    }

    public static void showConfusingToast(Context context, String message) {
        FancyToast.makeText(context, message, FancyToast.LENGTH_SHORT, FancyToast.CONFUSING,true).show();
    }

    public static void showCustomToastWithParam(Context context, String message, int duration, int type, boolean icon) {
        FancyToast.makeText(context, message, duration, type, icon).show();
    }

    public static void showCustomImageToastWithParam(Context context, String message, int duration, int type, int image, boolean icon) {
        FancyToast.makeText(context, message, duration, type, image, icon).show();
    }

    public static void showCustomToastWithoutIcon(Context context, String message, int duration, int type, int image) {
        FancyToast.makeText(context, message, duration, type, image, false);
    }

}
