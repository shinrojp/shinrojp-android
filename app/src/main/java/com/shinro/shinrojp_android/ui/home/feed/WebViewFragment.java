package com.shinro.shinrojp_android.ui.home.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.utils.AppLogger;
import com.shinro.shinrojp_android.utils.CommonUtils;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewFragment extends BaseFragment implements WebViewContract.View {

    @BindView(R.id.wvProgram) WebView wvProgram;
    @BindView(R.id.toolbar_feed) MaterialToolbar toolbar_feed;

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
        toolbar_feed.setNavigationIcon(R.drawable.ic_auth_back); // need to set the icon here to have a navigation icon. You can simple create an vector image by "Vector Asset" and using here
        toolbar_feed.setNavigationOnClickListener(view1 -> {

        });

        toolbar_feed.inflateMenu(R.menu.menu_feed);
        toolbar_feed.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.action_refresh) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        });

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_feed);

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

}
