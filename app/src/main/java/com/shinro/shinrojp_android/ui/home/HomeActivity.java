package com.shinro.shinrojp_android.ui.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.home.feed.FeedFragment;
import com.shinro.shinrojp_android.ui.home.lesson.LessonFragment;
import com.shinro.shinrojp_android.ui.home.quiz.QuizFragment;
import com.shinro.shinrojp_android.ui.home.user.UserFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.bottom_nav) BottomNavigationView bottom_nav;

    private HomeContract.Presenter mPresenter = new HomePresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initFirstFragment();
    }

    private void initView() {
        ButterKnife.bind(this);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);
    }

    private void initFirstFragment() {
        Fragment fragment = new FeedFragment();
        loadFragmentToContainer(R.id.frameContainer, fragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = menuItem -> {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_feed:
                fragment = new FeedFragment();
                break;
            case R.id.nav_learn:
                fragment = new LessonFragment();
                break;
            case R.id.nav_quiz:
                fragment = new QuizFragment();
                break;
            case R.id.nav_user:
                fragment = new UserFragment();
                break;
            default:
                break;
        }
        loadFragmentToContainer(R.id.frameContainer, fragment);
        return true;
    };

}
