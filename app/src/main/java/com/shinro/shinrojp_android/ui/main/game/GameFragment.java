package com.shinro.shinrojp_android.ui.main.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.ui.main.game.room.RoomFragment;

public class GameFragment extends BaseFragment implements GameContract.View {

    private GameContract.Presenter mPresenter = new GamePresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initFirstFragment();
    }

    private void initView() {

    }
    private void initFirstFragment() {
        Fragment fragment = new RoomFragment();
        loadFragmentToContainer(R.id.frameContainerGame, fragment);
    }

}
