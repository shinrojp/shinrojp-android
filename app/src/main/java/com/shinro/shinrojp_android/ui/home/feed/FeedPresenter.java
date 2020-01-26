package com.shinro.shinrojp_android.ui.home.feed;

public class FeedPresenter implements FeedContract.Presenter {

    private FeedContract.View mView;

    public FeedPresenter(FeedContract.View mView) {
        this.mView = mView;
    }

}
