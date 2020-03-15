package com.shinro.shinrojp_android.ui.main.grammar;

public class GrammarPresenter implements GrammarContract.Presenter {

    private GrammarContract.View mView;

    public GrammarPresenter(GrammarContract.View mView) {
        this.mView = mView;
    }

}
