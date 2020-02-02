package com.shinro.shinrojp_android.ui.common.note;

public class NotePresenter implements NoteContract.Presenter {

    private NoteContract.View mView;

    public NotePresenter(NoteContract.View mView) {
        this.mView = mView;
    }

}
