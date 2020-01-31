package com.shinro.shinrojp_android.ui.home.about;

public class AboutPresenter implements AboutContract.Presenter {

    private AboutContract.View mView;

    public AboutPresenter(AboutContract.View mView) {
        this.mView = mView;
    }

}
