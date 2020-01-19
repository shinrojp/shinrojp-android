package com.shinro.shinrojp_android.ui.intro;

import android.os.Bundle;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;

//todo create BaseActivity and import to this class
public class IntroActivity extends BaseActivity implements IntroContract.View {

    IntroContract.Presenter mPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mPresenter = new IntroPresenter(this, this);
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
    public void setPresenter(IntroContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
