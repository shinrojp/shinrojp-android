package com.shinro.shinrojp_android.ui.main.game.room.kanji;

public class KanjiPresenter implements KanjiContract.Presenter {

    private KanjiContract.View mView;

    public KanjiPresenter(KanjiContract.View mView) {
        this.mView = mView;
    }

}
