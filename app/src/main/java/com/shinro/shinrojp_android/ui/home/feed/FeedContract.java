package com.shinro.shinrojp_android.ui.home.feed;

import com.shinro.shinrojp_android.models.NHK.G1;

import java.util.ArrayList;

public interface FeedContract {

    interface View {
        void onFetchProgramListSuccess(ArrayList<G1> list);
        void onFetchProgramListFail(Throwable throwable);
    }

    interface Presenter {
        void onFetchProgramList(String current_date);
    }

}
