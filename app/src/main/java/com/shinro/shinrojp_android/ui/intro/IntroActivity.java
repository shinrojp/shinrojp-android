package com.shinro.shinrojp_android.ui.intro;

import android.os.Bundle;

class IntroActivity extends BaseActivity implements IntroContract.View { //TODO: DON'T FORGET TO ADD THIS ACTIVITY TO THE MANIFEST FILE!!!

    private IntroContract.Presenter mPresenter = new IntroPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);  //TODO: create the layout and add it here
        initView();
    }

    private void initView() {

    }

}
