package com.shinro.shinrojp_android.ui.home.feed;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.adapters.NHKProgramAdapter;
import com.shinro.shinrojp_android.adapters.SliderImageAdapter;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.utils.AppLogger;
import com.shinro.shinrojp_android.utils.CommonUtils;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedFragment extends BaseFragment implements FeedContract.View {

    @BindView(R.id.imageSlider) SliderView imageSlider;
    @BindView(R.id.rcvProgram) RecyclerView rcvProgram;
    @BindView(R.id.tvTip) MaterialTextView tvTip;

    private FeedContract.Presenter mPresenter = new FeedPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initSlider();
        fetchProgramListData();
    }

    private void initView(@NotNull View view) {
        ButterKnife.bind(this, view);
    }

    private void initSlider() {
        SliderImageAdapter adapter = new SliderImageAdapter(getContext());
        adapter.setCount(4);
        imageSlider.setSliderAdapter(adapter);

        imageSlider.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        imageSlider.setIndicatorSelectedColor(Color.WHITE);
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.setScrollTimeInSec(5);
        imageSlider.startAutoCycle();

        imageSlider.setOnIndicatorClickListener(position -> imageSlider.setCurrentPagePosition(position));
    }

    private void fetchProgramListData() {
        mPresenter.onFetchProgramList(CommonUtils.getSystemDate());
    }

    private void initRecyclerView(ArrayList<G1> g1s) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvProgram.setLayoutManager(linearLayoutManager);
        rcvProgram.setItemAnimator(new DefaultItemAnimator());
        rcvProgram.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        rcvProgram.setHasFixedSize(true);
        NHKProgramAdapter adapter = new NHKProgramAdapter(getActivity(), g1s);
        rcvProgram.setAdapter(adapter);
    }

    @Override
    public void onFetchProgramListSuccess(ArrayList<G1> list) {
        initRecyclerView(list);
    }

    @Override
    public void onFetchProgramListFail(Throwable throwable) {
        AppLogger.e(throwable);
    }
}
