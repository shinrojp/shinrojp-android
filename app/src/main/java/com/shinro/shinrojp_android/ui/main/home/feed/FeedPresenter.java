package com.shinro.shinrojp_android.ui.main.home.feed;

import com.shinro.shinrojp_android.api.ApiUtil;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.models.NHK.NHKProgramList;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.shinro.shinrojp_android.utils.Constants.NHK_API_KEY;

public class FeedPresenter implements FeedContract.Presenter {

    private FeedContract.View mView;

    public FeedPresenter(FeedContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onFetchProgramList(String current_date) {
        ApiUtil.getFeedApiService(false, null).fetchProgramList(current_date, NHK_API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NHKProgramList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NHKProgramList nhkProgramLists) {
                        mView.onFetchProgramListSuccess(convertObject(nhkProgramLists));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFetchProgramListFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private ArrayList<G1> convertObject(NHKProgramList model) {
        if(model != null) {
            return model.getList().getG1();
        }
        return null;
    }
}
