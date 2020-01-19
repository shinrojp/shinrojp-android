package com.shinro.shinrojp_android.ui.intro;

import android.content.Context;

import androidx.annotation.NonNull;

import com.shinro.shinrojp_android.bases.BasePresenter;

public class IntroPresenter extends BasePresenter implements IntroContract.Presenter {

    private IntroContract.View mView;

    private Context mContext;

    public IntroPresenter(@NonNull Context context, @NonNull IntroContract.View view) {
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
