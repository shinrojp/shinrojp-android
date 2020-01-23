package com.shinro.shinrojp_android.ui.auth.register;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;

public class RegisterActivity extends BaseActivity implements RegisterContract.View { //TODO: DON'T FORGET TO ADD THIS ACTIVITY TO THE MANIFEST FILE!!!

    private RegisterContract.Presenter mPresenter = new RegisterPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  //TODO: create the layout and add it here
        initView();
    }

    private void initView() {

    }

}
