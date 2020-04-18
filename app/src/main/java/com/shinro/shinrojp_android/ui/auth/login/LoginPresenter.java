package com.shinro.shinrojp_android.ui.auth.login;

import com.shinro.shinrojp_android.api.ApiUtil;
import com.shinro.shinrojp_android.models.LoginResponse;
import com.shinro.shinrojp_android.models.ServerResponse;
import com.shinro.shinrojp_android.utils.AppLogger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onLogin(String u, String p) {
        ApiUtil.userService(false, null).login(u, p)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse o) {
                        mView.onLoginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onLoginFail();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}