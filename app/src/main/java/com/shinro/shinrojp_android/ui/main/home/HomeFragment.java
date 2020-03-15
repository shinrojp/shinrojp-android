package com.shinro.shinrojp_android.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.bases.BaseFragment;
import com.shinro.shinrojp_android.ui.main.grammar.GrammarFragment;
import com.shinro.shinrojp_android.ui.main.home.feed.FeedFragment;
import com.shinro.shinrojp_android.ui.main.home.quiz.QuizFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    @BindView(R.id.bottom_nav_fhome) BottomNavigationView bottom_nav;

    private HomeContract.Presenter mPresenter = new HomePresenter(this);   // Presenter

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = menuItem -> {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.bottom_nav_feed:
                fragment = new FeedFragment();
                break;
            case R.id.bottom_nav_grammar:
                fragment = new GrammarFragment();
                break;
            case R.id.bottom_nav_quiz:
                fragment = new QuizFragment();
                break;
            default:
                break;
        }
        loadFragmentToContainer(R.id.frameContainerFhome, fragment);
        return true;
    };

}
