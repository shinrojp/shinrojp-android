package com.shinro.shinrojp_android.ui.home;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.ui.home.about.AboutFragment;
import com.shinro.shinrojp_android.ui.home.feed.FeedFragment;
import com.shinro.shinrojp_android.ui.home.feedback.FeedbackFragment;
import com.shinro.shinrojp_android.ui.home.lesson.LessonFragment;
import com.shinro.shinrojp_android.ui.home.note.NoteFragment;
import com.shinro.shinrojp_android.ui.home.quiz.QuizFragment;
import com.shinro.shinrojp_android.ui.home.user.UserFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends BaseActivity implements HomeContract.View, View.OnClickListener {

    @BindView(R.id.bottom_nav) BottomNavigationView bottom_nav;
    @BindView(R.id.drawer_layout) DrawerLayout drawer_layout;
    @BindView(R.id.drawer_nav) NavigationView drawer_nav;

    private CircleImageView civProfile;
    private View headerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private HomeContract.Presenter mPresenter = new HomePresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initDrawerNavigation(drawer_nav);
        initFirstFragment();
    }

    private void initView() {
        ButterKnife.bind(this);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);
    }

    private void initDrawerNavigation(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> {
            onSelectDrawerItem(item);
            return true;
        });
        //View headerLayout = drawer_nav.inflateHeaderView(R.layout.drawer_nav_header);

        if(navigationView.getHeaderCount() > 0) {
            headerLayout = navigationView.getHeaderView(0);
        }
        civProfile = headerLayout.findViewById(R.id.civProfile);

        civProfile.setOnClickListener(this);

        drawerToggle = initDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        drawer_layout.addDrawerListener(drawerToggle);
    }

    private ActionBarDrawerToggle initDrawerToggle() {
        return new ActionBarDrawerToggle(HomeActivity.this, drawer_layout, null, R.string.drawer_open, R.string.drawer_close);
    }

    private void onSelectDrawerItem(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.drawer_nav_note:
                fragment = new NoteFragment();
                break;
            case R.id.drawer_nav_feedback:
                fragment = new FeedbackFragment();
                break;
            case R.id.drawer_nav_about:
                fragment = new AboutFragment();
                break;
            case R.id.drawer_nav_sign_out:
                System.exit(0);
                break;
            default:
                break;
        }
        loadFragmentToContainer(R.id.frameContainer, fragment);
        setTitle(item.getTitle());
        drawer_layout.closeDrawers();
    }

    private void initFirstFragment() {
        Fragment fragment = new FeedFragment();
        loadFragmentToContainer(R.id.frameContainer, fragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = menuItem -> {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.bottom_nav_feed:
                fragment = new FeedFragment();
                break;
            case R.id.bottom_nav_learn:
                fragment = new LessonFragment();
                break;
            case R.id.bottom_nav_quiz:
                fragment = new QuizFragment();
                break;
            default:
                break;
        }
        loadFragmentToContainer(R.id.frameContainer, fragment);
        return true;
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.civProfile) {
            Fragment fragment  = new UserFragment();
            loadFragmentToContainer(R.id.frameContainer, fragment);
            drawer_layout.closeDrawers();
        }
    }
}
