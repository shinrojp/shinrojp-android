package com.shinro.shinrojp_android.ui.game.room;

public class RoomPresenter implements RoomContract.Presenter {

    private RoomContract.View mView;

    public RoomPresenter(RoomContract.View mView) {
        this.mView = mView;
    }

}
