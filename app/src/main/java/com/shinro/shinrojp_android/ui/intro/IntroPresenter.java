package com.shinro.shinrojp_android.ui.intro;

public class IntroPresenter implements IntroContract.Presenter {

    private IntroContract.View mView;

    public IntroPresenter(IntroContract.View mView) {
        this.mView = mView;
    }

}
