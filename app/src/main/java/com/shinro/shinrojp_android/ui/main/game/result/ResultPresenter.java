package com.shinro.shinrojp_android.ui.main.game.result;

public class ResultPresenter implements ResultContract.Presenter {

    private ResultContract.View mView;

    public ResultPresenter(ResultContract.View mView) {
        this.mView = mView;
    }

}
