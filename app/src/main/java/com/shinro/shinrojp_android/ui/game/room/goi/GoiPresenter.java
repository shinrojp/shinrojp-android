package com.shinro.shinrojp_android.ui.game.room.goi;

public class GoiPresenter implements GoiContract.Presenter {

    private GoiContract.View mView;

    public GoiPresenter(GoiContract.View mView) {
        this.mView = mView;
    }

}
