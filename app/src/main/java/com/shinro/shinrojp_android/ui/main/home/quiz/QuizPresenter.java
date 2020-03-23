package com.shinro.shinrojp_android.ui.main.home.quiz;

public class QuizPresenter implements QuizContract.Presenter {

    private QuizContract.View mView;

    public QuizPresenter(QuizContract.View mView) {
        this.mView = mView;
    }

}
