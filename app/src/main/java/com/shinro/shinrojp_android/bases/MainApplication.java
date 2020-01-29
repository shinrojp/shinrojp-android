package com.shinro.shinrojp_android.bases;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shinro.shinrojp_android.api.LenientTypeAdapterFactory;
import com.shinro.shinrojp_android.utils.AppLogger;

public class MainApplication extends Application {

    private Gson mGson;
    private MainApplication mSelf;

    public MainApplication self() {
        return mSelf;
    }

    public Gson getGson() {
        return mGson;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
        mGson = new GsonBuilder().registerTypeAdapterFactory(new LenientTypeAdapterFactory()).create();
        AppLogger.init();
    }

}
