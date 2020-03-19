package com.shinro.shinrojp_android.ui.main.game.room;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
import com.shinro.shinrojp_android.ui.main.game.start.StartFragment;

import butterknife.OnClick;

public class RoomFragment extends BaseFragment implements RoomContract.View {
    @BindView(R.id.view_page_room) ViewPager viewPager;
    @BindView(R.id.tabs) TabLayout tabs;
//    @BindView(R.id.btn_game_seach)
//    Button btn_search;
//    @BindView(R.id.btn_game_play)
//    Button btn_play;
//    @BindView(R.id.btn_game_creat)
//    Button btn_creat;
//
//    @BindView(R.id.btn_dialogCancel) Button btnCancel;
//
//    @BindView(R.id.btn_dialog_search) Button btnSearch;
//
//    @BindView(R.id.edt_id)
//    EditText edtIdEditText;
//    @BindView(R.id.edt_password) EditText edtPass;


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
    @OnClick(R.id.btn_game_play)
    protected void btnPlay(){
        Fragment fragment = new StartFragment();
        replaceFragment(R.id.frameContainer, fragment);
    }
    @OnClick(R.id.btn_game_seach)
    protected void btnSrarch(){
        dialogSearch();
    }
    private void dialogSearch(){
        Dialog dialog = new Dialog(getActivity(),R.style.Theme_AppCompat_DayNight_Dialog);
        dialog.setContentView(R.layout.dialog_search_game);
        dialog.show();

    }

    @OnClick(R.id.btn_game_creat)
    protected void btnCreat(){
        dialogCreat();
    }

    private void dialogCreat(){
        Dialog dialog = new Dialog(getActivity(),R.style.Theme_AppCompat_DayNight_Dialog);
        dialog.setContentView(R.layout.dialog_creat_game);
        dialog.show();

    }

}
