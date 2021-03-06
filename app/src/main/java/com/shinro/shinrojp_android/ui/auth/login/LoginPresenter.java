package com.shinro.shinrojp_android.ui.auth.login;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onLogin(String u, String p) {
        mView.onLoginSuccess();
    }
}
