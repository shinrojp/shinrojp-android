package com.shinro.shinrojp_android.ui.splash;

import android.content.Context;

import androidx.annotation.NonNull;

import com.shinro.shinrojp_android.bases.BasePresenter;


public class SplashPresenter extends BasePresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    private Context mContext;

    public SplashPresenter(@NonNull Context context, @NonNull SplashContract.View view) {
        this.mView = view;
        this.mContext = context;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
