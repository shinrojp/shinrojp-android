package com.shinro.shinrojp_android.ui.splash;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    public SplashPresenter(SplashContract.View mView) {
        this.mView = mView;
    }

}
