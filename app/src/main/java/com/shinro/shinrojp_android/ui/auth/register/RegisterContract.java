package com.shinro.shinrojp_android.ui.auth.register;

import com.shinro.shinrojp_android.models.ServerResponse;

public interface RegisterContract {

    interface View {
        void onRegisterSuccess(ServerResponse serverResponse);
        void onRegisterFail(ServerResponse serverResponse);
    }

    interface Presenter {
        void onRegister(String name, String email, String password,String repassword);
    }

}
