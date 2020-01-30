package com.shinro.shinrojp_android.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;

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

}
