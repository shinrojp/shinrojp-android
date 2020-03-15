package com.shinro.shinrojp_android.ui.main.home.feed;


import com.shinro.shinrojp_android.models.NHK.G1;

public interface WebViewContract {

    interface View {
        void onFetchProgramUrlSuccess(G1 model);
        void onFetchProgramUrlFail(Throwable e);
    }

    interface Presenter {
        void onFetchProgramUrl(String id);
    }

}
