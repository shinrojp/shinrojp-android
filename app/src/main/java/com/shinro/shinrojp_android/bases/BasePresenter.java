package com.shinro.shinrojp_android.bases;

import android.content.Context;

import androidx.annotation.NonNull;

public class BasePresenter {

    protected Context mContext;

    public void subscribe(@NonNull Context context) {
        this.mContext = context;
    }

    public boolean isSubscribed() {
        return mContext != null;
    }

}
