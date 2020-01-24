package com.shinro.shinrojp_android.ui.auth.register;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;

    public RegisterPresenter(RegisterContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onRegister(String u, String e, String p) {
        mView.onRegisterSuccess();
    }
}
