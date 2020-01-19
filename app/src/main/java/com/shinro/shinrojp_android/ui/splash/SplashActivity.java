package com.shinro.shinrojp_android.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.intro.IntroActivity;

import static com.shinro.shinrojp_android.ultis.Constants.SPLASH_TIME_OUT;

//todo create BaseActivity and import to this class
public class SplashActivity extends BaseActivity implements SplashContract.View{

    SplashContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPresenter = new SplashPresenter(this, this);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, IntroActivity.class);
            finish();
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
