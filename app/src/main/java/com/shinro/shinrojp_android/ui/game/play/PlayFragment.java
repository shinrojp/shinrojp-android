package com.shinro.shinrojp_android.ui.game.play;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;

public class PlayFragment extends BaseFragment implements PlayContract.View {

    private PlayContract.Presenter mPresenter = new PlayPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {

    }

}
