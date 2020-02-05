package com.shinro.shinrojp_android.ui.home.feed;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.google.android.material.textview.MaterialTextView;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.adapters.NHKProgramAdapter;
import com.shinro.shinrojp_android.adapters.SliderImageAdapter;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.utils.AppLogger;
import com.shinro.shinrojp_android.utils.CommonUtils;
import com.shinro.shinrojp_android.utils.ProgressDialogUtils;
import com.shinro.shinrojp_android.utils.RecyclerViewUtils.CustomSnapHelper;
import com.shinro.shinrojp_android.utils.RecyclerViewUtils.RecyclerViewClickListener;
import com.shinro.shinrojp_android.utils.RecyclerViewUtils.RecyclerViewTouchListener;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.shinro.shinrojp_android.utils.Constants.SYSTEM_DATE;

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
        mPresenter.onFetchProgramList(SYSTEM_DATE);
        onShowLoading();
    }

    private void initRecyclerView(ArrayList<G1> g1s) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rcvProgram.setLayoutManager(linearLayoutManager);
        rcvProgram.setItemAnimator(new DefaultItemAnimator());
        rcvProgram.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        rcvProgram.setHasFixedSize(true);
        NHKProgramAdapter adapter = new NHKProgramAdapter(getActivity(), g1s);
        rcvProgram.setAdapter(adapter);
        SnapHelper snapHelper = new CustomSnapHelper();
        snapHelper.attachToRecyclerView(rcvProgram);
        rcvProgram.addOnItemTouchListener(new RecyclerViewTouchListener(getActivity(), rcvProgram, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int pos) {
                String id = g1s.get(pos).getId();
                Bundle bundle = new Bundle();
                bundle.putString("nhk_id", id);
                WebViewFragment fragment = new WebViewFragment();
                fragment.setArguments(bundle);
                replaceFragmentFromFragment(fragment);
            }

            @Override
            public void onLongClick(View view, int pos) {

            }
        }));
    }

    @Override
    public void onFetchProgramListSuccess(ArrayList<G1> list) {
        if(list.size() != 0) {
            onHideLoading();
            initRecyclerView(list);
        }else{
            fetchProgramListData();
        }
    }

    @Override
    public void onFetchProgramListFail(Throwable throwable) {
        AppLogger.e(throwable);
    }

}
