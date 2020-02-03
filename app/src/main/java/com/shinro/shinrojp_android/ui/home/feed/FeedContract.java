package com.shinro.shinrojp_android.ui.home.feed;

import com.shinro.shinrojp_android.models.NHKProgramList;

import java.util.ArrayList;

public interface FeedContract {

    interface View {
        void onFetchProgramListSuccess(ArrayList<NHKProgramList> list);
        void onFetchProgramListFail(Throwable throwable);
    }

    interface Presenter {
        void onFetchProgramList(String current_date);
    }

}
