package com.shinro.shinrojp_android.ui.main.game;

public class GamePresenter implements GameContract.Presenter {

    private GameContract.View mView;

    public GamePresenter(GameContract.View mView) {
        this.mView = mView;
    }

}
