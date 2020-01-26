package com.shinro.shinrojp_android.ui.home;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private HomeContract.Presenter mPresenter = new HomePresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {

    }

}
