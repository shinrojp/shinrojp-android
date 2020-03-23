package com.shinro.shinrojp_android.ui.main.grammar.detail;

public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View mView;

    public DetailPresenter(DetailContract.View mView) {
        this.mView = mView;
    }

}
