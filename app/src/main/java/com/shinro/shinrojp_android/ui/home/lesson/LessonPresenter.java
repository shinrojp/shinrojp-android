package com.shinro.shinrojp_android.ui.home.lesson;

public class LessonPresenter implements LessonContract.Presenter {

    private LessonContract.View mView;

    public LessonPresenter(LessonContract.View mView) {
        this.mView = mView;
    }

}
