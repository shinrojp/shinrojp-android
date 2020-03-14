package com.shinro.shinrojp_android.ui.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.game.room.RoomFragment;
import com.shinro.shinrojp_android.ui.home.feed.FeedFragment;

public class GameActivity extends BaseActivity implements GameContract.View { //TODO: DON'T FORGET TO ADD THIS ACTIVITY TO THE MANIFEST FILE!!!

    private GameContract.Presenter mPresenter = new GamePresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_game);  //TODO: create the layout and add it here
        initView();
        initFirstFragment();
    }
    private void initFirstFragment() {
        Fragment fragment = new RoomFragment();
        loadFragmentToContainer(R.id.frameContainerGame, fragment);
    }
    private void initView() {

    }

}
