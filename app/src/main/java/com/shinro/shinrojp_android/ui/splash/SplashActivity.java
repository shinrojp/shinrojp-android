package com.shinro.shinrojp_android.ui.splash;

import android.os.Bundle;

class SplashActivity extends BaseActivity implements SplashContract.View { //TODO: DON'T FORGET TO ADD THIS ACTIVITY TO THE MANIFEST FILE!!!

    private SplashContract.Presenter mPresenter = new SplashPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);  //TODO: create the layout and add it here
        initView();
    }

    private void initView() {

    }

}
