package com.shinro.shinrojp_android.ui.home.feedback;

public class FeedbackPresenter implements FeedbackContract.Presenter {

    private FeedbackContract.View mView;

    public FeedbackPresenter(FeedbackContract.View mView) {
        this.mView = mView;
    }

}
