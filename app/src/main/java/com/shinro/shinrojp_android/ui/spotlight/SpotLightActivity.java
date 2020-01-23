package com.shinro.shinrojp_android.ui.spotlight;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;

public class SpotLightActivity extends BaseActivity implements SpotLightContract.View {

    private SpotLightContract.Presenter mPresenter = new SpotLightPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spot_light_acitivty);
        initView();
    }

    private void initView() {

    }

}
