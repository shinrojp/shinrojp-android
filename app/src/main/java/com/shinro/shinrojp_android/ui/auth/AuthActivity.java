package com.shinro.shinrojp_android.ui.auth;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.auth.login.LoginActivity;
import com.shinro.shinrojp_android.ui.auth.register.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        initView();
    }

    @OnClick(R.id.tvLogin)
    protected void navigateLogin(){
        navigateActivity(LoginActivity.class);
        finish();
    }

    @OnClick(R.id.tvRegister)
    protected void navigateRegister(){
        navigateActivity(RegisterActivity.class);
        finish();
    }

    private void initView() {
        ButterKnife.bind(this);
    }



}
