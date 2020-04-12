package com.shinro.shinrojp_android.ui.auth.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.models.Msg;
import com.shinro.shinrojp_android.models.ServerResponse;
import com.shinro.shinrojp_android.models.User;
import com.shinro.shinrojp_android.ui.auth.AuthActivity;
import com.shinro.shinrojp_android.utils.CommonUtils;
import com.shinro.shinrojp_android.views.CustomEditText;
import com.shinro.shinrojp_android.views.CustomTextView;

public class RegisterActivity extends BaseActivity implements RegisterContract.View, View.OnClickListener {

    private ImageView imvBack;
    private CustomEditText edtUsername;
    private CustomEditText edtEmail;
    private CustomEditText edtPassword;
    private CustomEditText edtRePassword;
    private CustomTextView btnRegister;

    private RegisterContract.Presenter mPresenter = new RegisterPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        imvBack.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    private void initView() {
        imvBack = findViewById(R.id.imvBack);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
        btnRegister = findViewById(R.id.btnRegister);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CommonUtils.hideKeyBoardOnBlur(edtUsername);
        CommonUtils.hideKeyBoardOnBlur(edtEmail);
        CommonUtils.hideKeyBoardOnBlur(edtPassword);
        CommonUtils.hideKeyBoardOnBlur(edtRePassword);
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
            case R.id.btnRegister:
                String name = edtUsername.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String repassword = edtRePassword.getText().toString().trim();
                mPresenter.onRegister(name, email, password,repassword);
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
    public void onRegisterSuccess(ServerResponse serverResponse) {
        for(Msg a : serverResponse.getMsgs()) {
            if (a.getType().equals("success")){
                //CommonUtils.showSuccessToast(this, a.getMsg() + a.getCss() + a.getType());
                CommonUtils.showSuccessToast(this, a.getMsg());
                navigateAuth();}
            else {
                CommonUtils.showErrorToast(this, a.getMsg());
                break;
            }
        }


    }

    @Override
    public void onRegisterFail(ServerResponse serverResponse) {
        Toast.makeText(getApplicationContext(),"Er",Toast.LENGTH_LONG).show();
    }

}
