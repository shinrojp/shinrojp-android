package com.shinro.shinrojp_android.ui.intro;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.adapters.IntroViewPagerAdapter;
import com.shinro.shinrojp_android.bases.BaseActivity;
import com.shinro.shinrojp_android.helpers.SharedPreferencesHelper;
import com.shinro.shinrojp_android.ui.auth.AuthActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroActivity extends BaseActivity implements IntroContract.View {

    //Init View
    @BindView(R.id.view_pager) ViewPager viewPager;
    @BindView(R.id.layoutDots) LinearLayout dotsLayout;
    @BindView(R.id.btn_next) Button btnNext;
    @BindView(R.id.btn_skip) Button btnSkip;

    //Init IntroViewPagerAdapter
    private IntroViewPagerAdapter adapter;
    private SharedPreferencesHelper preferencesHelper;

    private TextView[] dots;
    private int[] layouts;

    private IntroContract.Presenter mPresenter = new IntroPresenter(this);    // Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencesHelper = SharedPreferencesHelper.getInstance(this);

        if(!preferencesHelper.isFirstTimeLaunch()){
            preferencesHelper.setFirstTimeLaunch(false);
            navigateActivity(AuthActivity.class);
            finish();
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_intro);
        initView();

        initIntroSlider();
        addBottomDots(0);
        changeStatusBarColor();
        initViewPager();

        btnNext.setOnClickListener(view -> {
            int current = getItem(+1);
            if(current < layouts.length) {
                viewPager.setCurrentItem(current);
            } else {
                preferencesHelper.setFirstTimeLaunch(false);
                navigateActivity(AuthActivity.class);
                finish();
            }
        });

        btnSkip.setOnClickListener(view -> {
            preferencesHelper.setFirstTimeLaunch(false);
            navigateActivity(AuthActivity.class);
            finish();
        });

    }

    private void initView() {
        ButterKnife.bind(this);
    }

    private void initIntroSlider() {
        layouts = new int[]{
                R.layout.intro_slider_first,
                R.layout.intro_slider_second,
                R.layout.intro_slider_third,
                R.layout.intro_slider_fourth};
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private void initViewPager() {
        adapter = new IntroViewPagerAdapter(layouts, this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(initViewPagerPageChangeListener());
    }

    private ViewPager.OnPageChangeListener initViewPagerPageChangeListener() {
        ViewPager.OnPageChangeListener viewOnPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == layouts.length - 1) {
                    // last page. make button text to GOT IT
                    btnNext.setText(getString(R.string.start));
                    btnSkip.setVisibility(View.GONE);
                } else {
                    // still pages are left
                    btnNext.setText(getString(R.string.next));
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        return viewOnPageChangeListener;
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
