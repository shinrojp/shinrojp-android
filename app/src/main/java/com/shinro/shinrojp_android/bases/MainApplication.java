package com.shinro.shinrojp_android.bases;

import android.app.Application;

import com.shinro.shinrojp_android.BuildConfig;

import timber.log.Timber;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
