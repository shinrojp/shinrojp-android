package com.shinro.shinrojp_android.ui.common.setting;

public class SettingPresenter implements SettingContract.Presenter {

    private SettingContract.View mView;

    public SettingPresenter(SettingContract.View mView) {
        this.mView = mView;
    }

}
