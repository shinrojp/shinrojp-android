package com.shinro.shinrojp_android.ui.main.game.play;

public class PlayPresenter implements PlayContract.Presenter {

    private PlayContract.View mView;

    public PlayPresenter(PlayContract.View mView) {
        this.mView = mView;
    }

}