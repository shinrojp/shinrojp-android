package com.shinro.shinrojp_android.ui.game.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.ui.game.play.PlayFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartFragment extends BaseFragment implements StartContract.View {

    private StartContract.Presenter mPresenter = new StartPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btn_game_start)
    protected void btnStart(){
        Fragment fragment = new PlayFragment();
        replaceFragment(R.id.frameContainerGame, fragment);
    }

}
