package com.shinro.shinrojp_android.ui.home.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.models.NHK.NHKProgramList;
import com.shinro.shinrojp_android.utils.AppLogger;

import java.util.ArrayList;

public class FeedFragment extends BaseFragment implements FeedContract.View {

    private FeedContract.Presenter mPresenter = new FeedPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {

    }

    @Override
    public void onFetchProgramListSuccess(ArrayList<NHKProgramList> list) {

    }

    @Override
    public void onFetchProgramListFail(Throwable throwable) {
        AppLogger.e(throwable);
    }
}
