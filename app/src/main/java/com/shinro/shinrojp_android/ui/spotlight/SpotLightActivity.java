package com.shinro.shinrojp_android.ui.spotlight;

import android.os.Bundle;

class SpotLightActivity extends BaseActivity implements SpotLightContract.View { //TODO: DON'T FORGET TO ADD THIS ACTIVITY TO THE MANIFEST FILE!!!

    private SpotLightContract.Presenter mPresenter = new SpotLightPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);  //TODO: create the layout and add it here
        initView();
    }

    private void initView() {

    }

}
