package com.shinro.shinrojp_android.ui.game.room;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.google.android.material.tabs.TabLayout;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.adapters.TabsPagerAdapter;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.ui.game.play.PlayFragment;

import butterknife.OnClick;

public class RoomFragment extends BaseFragment implements RoomContract.View {
    @BindView(R.id.view_page_room) ViewPager viewPager;
    @BindView(R.id.tabs) TabLayout tabs;
    @BindView(R.id.btn_game_play)  Button btnPlay;


    private RoomContract.Presenter mPresenter = new RoomPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(getActivity(), getFragmentManager());
        viewPager.setAdapter(tabsPagerAdapter);
        tabs.setupWithViewPager(viewPager);


    }
    private void initView(View view) {
        ButterKnife.bind(this, view);
    }
    @OnClick(R.id.tvLogin)
    protected void btnPlay(){
        Fragment fragment = new PlayFragment();
        loadFragmentToContainer(R.id.frameContainerGame, fragment);
    }

}
