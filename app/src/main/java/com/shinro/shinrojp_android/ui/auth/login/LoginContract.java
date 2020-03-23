package com.shinro.shinrojp_android.ui.auth.login;

public interface LoginContract {

    interface View {
        void onLoginSuccess();
        void onLoginFail();
    }

    interface Presenter {
        void onLogin(String u, String p);
    }

}
