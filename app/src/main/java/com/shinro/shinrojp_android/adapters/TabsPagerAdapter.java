package com.shinro.shinrojp_android.adapters;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shinro.shinrojp_android.R;
import com.shinro.shinrojp_android.ui.game.room.bunpou.BunpouFragment;
import com.shinro.shinrojp_android.ui.game.room.goi.GoiFragment;
import com.shinro.shinrojp_android.ui.game.room.kanji.KanjiFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES =
            new int[] { R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3 };
    private final Context mContext;
    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return GoiFragment.newInstance();
            case 1:
                return KanjiFragment.newInstance();
            case 2:
                return BunpouFragment.newInstance();
            default:
                return null;
        }
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}
