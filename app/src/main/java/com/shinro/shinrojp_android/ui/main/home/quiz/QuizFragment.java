package com.shinro.shinrojp_android.ui.main.home.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.ui.main.game.GameActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizFragment extends BaseFragment implements QuizContract.View {

    @BindView(R.id.edtInviteCode) TextInputEditText edtInviteCode;

    private QuizContract.Presenter mPresenter = new QuizPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btnJoinGame)
    protected void onJoinGame() {
        navigateActivity(GameActivity.class);
    }

}