package com.shinro.shinrojp_android.ui.auth.register;

public interface RegisterContract {

    interface View {
        void onRegisterSuccess();
        void onRegisterFail();
    }

    interface Presenter {
        void onRegister(String u, String e, String p);
    }

}
