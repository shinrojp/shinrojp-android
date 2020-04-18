package com.shinro.shinrojp_android.ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.auth.AuthActivity;
import com.shinro.shinrojp_android.ui.main.HomeActivity;
import com.shinro.shinrojp_android.utils.CommonUtils;
import com.shinro.shinrojp_android.views.CustomEditText;
import com.shinro.shinrojp_android.views.CustomTextView;

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener {

    private ImageView imvBack;
    private CustomEditText edtUsername;
    private CustomEditText edtPassword;
    private CustomTextView btnLogin;

    private LoginContract.Presenter mPresenter = new LoginPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        imvBack.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void initView() {
        imvBack = findViewById(R.id.imvBack);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CommonUtils.hideKeyBoardOnBlur(edtUsername);
        CommonUtils.hideKeyBoardOnBlur(edtPassword);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigateAuth();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.imvBack:
                navigateAuth();
                break;
            case R.id.btnLogin:
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                mPresenter.onLogin(username, password);
                break;
            default:
                break;
        }
    }

    private void navigateAuth() {
        navigateActivity(AuthActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

    @Override
    public void onLoginSuccess() {
        navigateActivity(HomeActivity.class);
        finish();
    }

    @Override
    public void onLoginFail() {
        CommonUtils.showErrorToast(this, "Incorrect password/username.");
    }

}
