package com.shinro.shinrojp_android.ui.common;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.common.about.AboutFragment;
import com.shinro.shinrojp_android.ui.common.feedback.FeedbackFragment;
import com.shinro.shinrojp_android.ui.common.note.NoteFragment;
import com.shinro.shinrojp_android.ui.common.setting.SettingFragment;

public class CommonActivity extends BaseActivity implements CommonContract.View {

    int type_fragment;

    private CommonContract.Presenter mPresenter = new CommonPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type_fragment = getIntent().getIntExtra("type_fragment", 0);
        setContentView(R.layout.acitivty_common);
        initView();
    }

    private void initView() {
        initFragment(type_fragment);
    }

    private void initFragment(int v) {
        Fragment fragment = null;
        switch (v) {
            case 1:
                fragment = new NoteFragment();
                getSupportActionBar().setTitle("Note");
                break;
            case 2:
                fragment = new SettingFragment();
                getSupportActionBar().setTitle("Setting");
                break;

            case 3:
                fragment = new FeedbackFragment();
                getSupportActionBar().setTitle("Feedback");
                break;

            case 4:
                fragment = new AboutFragment();
                getSupportActionBar().setTitle("About");
                break;

            default:
                break;
        }
        loadFragmentToContainer(R.id.frameContainer, fragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
