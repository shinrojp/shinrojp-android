package com.shinro.shinrojp_android.ui.auth.login;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginContract.View { //TODO: DON'T FORGET TO ADD THIS ACTIVITY TO THE MANIFEST FILE!!!

    private LoginContract.Presenter mPresenter = new LoginPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  //TODO: create the layout and add it here
        initView();
    }

    private void initView() {

    }

}
