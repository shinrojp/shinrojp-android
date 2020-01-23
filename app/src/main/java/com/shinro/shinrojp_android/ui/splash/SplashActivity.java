package com.shinro.shinrojp_android.ui.splash;

import android.os.Bundle;
import android.os.Handler;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivityFullScreen;
import com.shinro.shinrojp_android.ui.intro.IntroActivity;

import static com.shinro.shinrojp_android.utils.Constants.SPLASH_TIME_OUT;

public class SplashActivity extends BaseActivityFullScreen implements SplashContract.View {

    private SplashContract.Presenter mPresenter = new SplashPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(() -> {
            navigateActivity(IntroActivity.class);
            finish();
        },SPLASH_TIME_OUT);
    }

}
