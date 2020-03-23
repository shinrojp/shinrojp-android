package com.shinro.shinrojp_android.ui.common;

public class CommonPresenter implements CommonContract.Presenter {

    private CommonContract.View mView;

    public CommonPresenter(CommonContract.View mView) {
        this.mView = mView;
    }

}
