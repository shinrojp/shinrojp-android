package com.shinro.shinrojp_android.ui.auth.register;

import com.shinro.shinrojp_android.api.ApiUtil;
import com.shinro.shinrojp_android.models.ServerResponse;
import com.shinro.shinrojp_android.utils.AppLogger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;

    public RegisterPresenter(RegisterContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onRegister(String name, String email, String password, String repassword) {
        // mView.onRegisterSuccess();
        ApiUtil.registerAccount(false, null).register(name, email, password, repassword)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ServerResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ServerResponse serverResponse) {
                        mView.onRegisterSuccess(serverResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        AppLogger.e(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
