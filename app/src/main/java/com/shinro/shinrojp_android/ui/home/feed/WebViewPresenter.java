package com.shinro.shinrojp_android.ui.home.feed;

import com.shinro.shinrojp_android.api.ApiUtil;
import com.shinro.shinrojp_android.models.NHK.G1;
import com.shinro.shinrojp_android.models.NHK.NHKProgramList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.shinro.shinrojp_android.utils.Constants.NHK_API_KEY;

public class WebViewPresenter implements WebViewContract.Presenter {

    private WebViewContract.View mView;

    public WebViewPresenter(WebViewContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onFetchProgramUrl(String id) {
        ApiUtil.getFeedApiService(false, null).fetchProgramDetail(id, NHK_API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NHKProgramList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NHKProgramList nhkProgramList) {
                        mView.onFetchProgramUrlSuccess(convertObject(nhkProgramList));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFetchProgramUrlFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private G1 convertObject(NHKProgramList model) {
        if(model != null) {
            return model.getList().getG1().get(0);
        }
        return null;
    }

}
