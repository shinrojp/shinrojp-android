package com.shinro.shinrojp_android.ui.home.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.utils.AppLogger;
import com.shinro.shinrojp_android.utils.CommonUtils;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewFragment extends BaseFragment implements WebViewContract.View, View.OnClickListener {

    @BindView(R.id.wvProgram) WebView wvProgram;
    @BindView(R.id.imvBack) ImageView imvBack;
    @BindView(R.id.imvReload) ImageView imvReload;

    private String id;

    private WebViewContract.Presenter mPresenter = new WebViewPresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_web, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initImageUrl();
    }

    private void initView(@NotNull View view) {
        ButterKnife.bind(this, view);
        imvBack.setOnClickListener(this);
        imvReload.setOnClickListener(this);
    }

    private void initImageUrl() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            id = bundle.getString("nhk_id", "");
        }
        mPresenter.onFetchProgramUrl(id);
    }

    private void initWebView(String url) {
        // Enable Javascript
        WebSettings webSettings = wvProgram.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        // Force links and redirects to open in the WebView instead of in a browser
        wvProgram.setWebViewClient(new WebViewClient());
        wvProgram.loadUrl(CommonUtils.getProgramUrlForWebView(url));
    }

    @Override
    public void onFetchProgramUrlSuccess(G1 model) {
        initWebView(model.getProgramUrl());
    }

    @Override
    public void onFetchProgramUrlFail(Throwable e) {
        AppLogger.e(e);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imvBack:
                int countStack = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                if (countStack > 1) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
                break;
            case R.id.imvReload:
                wvProgram.reload();
                break;
            default:
                break;
        }
    }
}
