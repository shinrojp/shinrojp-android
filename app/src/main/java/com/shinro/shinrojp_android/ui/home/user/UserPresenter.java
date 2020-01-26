package com.shinro.shinrojp_android.ui.home.user;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View mView;

    public UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }

}
